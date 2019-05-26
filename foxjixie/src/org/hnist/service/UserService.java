package org.hnist.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hnist.dao.UserDao;
import org.hnist.modul.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {
	
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 是否存在此账户
	 * @param userCount 账号
	 * @param password  密码
	 * @return
	 *   boolean
	 */
	public boolean existUser(String userCount,String password){
		List<User> userlist=userDao.findByUser(userCount, password);
		if(userlist.size()>0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 判断是否存在此用户 
	 * @param telPhone 手机号码
	 * @param userName 姓名
	 * @return
	 */
	public boolean existFindUser(String telPhone,String userName){
		List<User> userlist=userDao.findUser(telPhone, userName);
		if(userlist.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 通过姓名和手机查找该用户的账号
	 * @param telPhone
	 * @param userName
	 * @return
	 */
	public String findCountByUser(String telPhone,String userName){
		List<User> userlist=userDao.findUser(telPhone, userName);
		User user=userlist.get(0);
		return user.getUserCount();
	}
	
	/**
	 * 插入新数据的方法
	 * @param user user对象
	 * @return
	 */
	public String insertUser(User user){
		
		
		List<User> nlist=userDao.findByUserNo(user.getUserNo());
		List<User> uclist=userDao.findByUserCount(user.getUserCount());
		List<User> utlist=userDao.findBytelPhone(user.getTelPhone());
		
		if(nlist.size()>0){//判断学号是否存在
			return "01";
		}else if(uclist.size()>0){	//判断账号是否注册
			return "02";
		}else if(utlist.size()>0){	//判断电话号码是否已被注册
			return "03";
		}else{
			userDao.saveUser(user);
			return "ok";
		}
		
		
	
	}
	
	/**
	 * 更改用户的密码
	 * @param userCount 账号
	 * @param password  密码
	 * @return
	 * 		此方法是系统自动调用，不开放给用户使用
	 */
	public boolean saveUserPassword(String userCount,String password){
		User user=userDao.findByUserCount(userCount).get(0);
		user.setUserPassword(password);
		userDao.updateUser(user);
		return true;
	}
	
	/**
	 * 查找所有的会员
	 * @return
	 */
	public List<User> queryAllUser(){
		return userDao.findAllUser();
	}
	
	/**
	 * 通过序号删除会员
	 * @param userid
	 */
	public void deleteUser(Integer userid){
		if(!userDao.findUserById(userid).isEmpty()){
			userDao.deleteUser(userid);
		}
	}

	/**
	 * 通过序号查找该会员
	 * @param uid
	 * @return
	 */
	public User findUserByid(Integer uid){
		return userDao.findUserById(uid).get(0);
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user){
		try{
			//判断在user与数据库中不同于user的数据
			
			//账号
			List<User> uclist=userDao.findByUserCount(user.getUserCount());
			
			if(uclist.size()>0){
				if(uclist.get(0).getUserid().equals(user.getUserid())){
					uclist=new ArrayList<User>();
				}
			}
			
			//学号
			List<User> unlist=userDao.findByUserName(user.getUserNo());
			
			if(unlist.size()>0){
				if(unlist.get(0).getUserid().equals(user.getUserid())){
					unlist=new ArrayList<User>();
				}
				
			}
			
			//电话号码
			List<User> utlist=userDao.findBytelPhone(user.getTelPhone());
			
			if(utlist.size()>0){
				if(utlist.get(0).getUserid().equals(user.getUserid())){
					utlist=new ArrayList<User>();
				}
			}
			
			
			if(uclist.size()>0 || unlist.size()>0 || utlist.size()>0 ){
				return false;
				
			}else{
				//清除session  防止出现org.hibernate.NonUniqueObjectException错误
				userDao.getHibernateTemplate().getSessionFactory().getCurrentSession().clear();
				userDao.updateUser(user);
				return true;
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 根据路径文件批量将excel文件导入数据库中
	 * @param path
	 */
	public boolean saveUserByexcel(String path,Integer temp){
		
		int userSize=userDao.findAllUser().size();
		User userExcel;
		System.out.println("path:"+path);
		
		//对.xls文件的操作 《暂不可用》
		if(temp==1){
			try{
				//创建对excel文档的引用
				HSSFWorkbook wookbook=new HSSFWorkbook(new FileInputStream(new File(path)));
			
				HSSFSheet sheet=wookbook.getSheetAt(0);
				//获取excel所有的行数
				int rows=sheet.getPhysicalNumberOfRows();
				//行遍历
				for(int i=0;i<rows;i++){
					//读取左上端的单元格
					HSSFRow row=sheet.getRow(i);
					String[] value=new String[7];
					//行不为空
					if(row!=null){
						//获取Excel所有的列
						int cells=row.getPhysicalNumberOfCells();
						
						
					}
				}
						
				return true;
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return false;
		}
		
		//对.xlsx文件的操作
		if(temp==2){
			try{
				
				XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(new File(path)));
				XSSFSheet sheet=wb.getSheetAt(0);
				
				//获取所有的行数
				int rowNumber=sheet.getPhysicalNumberOfRows();
				for(int i=1;i<rowNumber;i++){
					
					//初始化User对象
					userExcel=new User();
					
					//读取Excel内容
					XSSFRow row=sheet.getRow(i);
					if(row!=null){
						
						//获取行数
						int cells=row.getPhysicalNumberOfCells();
						for(int j=0;j<cells;j++){
							
							//获取第几行
							XSSFCell cell=row.getCell((short)j);
							//将所有的行数据改为String
							cell.setCellType(Cell.CELL_TYPE_STRING);
							switch(j){
							    case 0:
									userExcel.setUserNo(cell.getStringCellValue());break;
								case 1:
									userExcel.setUserCount(cell.getStringCellValue());break;
								case 2:
									userExcel.setUserName(cell.getStringCellValue());break;
								case 3:
									userExcel.setUserPassword(cell.getStringCellValue());break;
								case 4:
									userExcel.setUserCollege(cell.getStringCellValue());break;
								case 5:
									userExcel.setTelPhone(cell.getStringCellValue());break;
								case 6:
									userExcel.setEmail(cell.getStringCellValue());break;
							}
							
							
						}
						userExcel.setUserid(userSize+i-1);
						//System.out.println("userExcel:"+userExcel.getUserNo()+"账号："+userExcel.getUserCount()+"密码:"+userExcel.getUserPassword());
						userDao.saveUser(userExcel);
					}
				}
				
				return true;
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return false;
		}
		
		return false;
	}
	
	
	public String exportUserExcel(){
		List<User> userlist=userDao.findAllUser();
		
		try{
			
			Workbook wb=new XSSFWorkbook();
			
			
			String[] excelTitle={"序号","学号","账号","姓名","学院","电话号码","邮箱"};
			
			//创建Sheet对象
			String sheetName="会员信息一览表";
			Sheet stuSheet=wb.createSheet(sheetName);
			
			//获取首页，并进行编辑
			Row titleRow=stuSheet.createRow(0);
			//创建单元格，设置style剧中 字体 单元格大小等
			CellStyle style=wb.createCellStyle();
			Cell cell=null;
			
			//把标题写入Excel首行
			for(int i=0;i<excelTitle.length;i++){
				cell=titleRow.createCell(i);
				cell.setCellValue(excelTitle[i]);
				cell.setCellStyle(style);
			}
			
			//把从数据库中取得的数据写入exccel文件中
			Row row=null;
			
			for(int i=0;i<userlist.size();i++){
				
				//在i+1处加入行
				row=stuSheet.createRow(i+1);
				
				//设置各列的值
				row.createCell(0).setCellValue(i+1);
				row.createCell(1).setCellValue(userlist.get(i).getUserNo());
				row.createCell(2).setCellValue(userlist.get(i).getUserCount());
				row.createCell(3).setCellValue(userlist.get(i).getUserName());
				row.createCell(4).setCellValue(userlist.get(i).getUserCollege());
				row.createCell(5).setCellValue(userlist.get(i).getTelPhone());
				row.createCell(6).setCellValue(userlist.get(i).getEmail());
			}
			
			
			//设置单元格宽度自适应，再次基础上把宽度调制1.5倍
			for(int i=0;i<excelTitle.length;i++){
				stuSheet.autoSizeColumn(i,true);
				stuSheet.setColumnWidth(i, stuSheet.getColumnWidth(i)*15/10);
			}
			
			//本地保存的绝对地址
			String path="G:\\Myeclips-workspace\\apache-tomcat-8.5.12\\webapps\\foxjixie\\public\\uploadExcel\\";
			//云服务器地址
			//String path="C:\\Tomcat 8.0\\webapps\\foxjixie\\public\\uploadExcel\\";
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			
			File file=new File(path);
			if(!file.exists()){
				file.mkdir();
			}
			
			String fileName=sheetName;
			//System.out.println("fileName"+fileName);
			
			String outputPath=path+fileName+sdf.format(date)+".xlsx";
			
			//输出Excel
			OutputStream fileOut=new FileOutputStream(outputPath);
			wb.write(fileOut);
			fileOut.close();
			
			return outputPath;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
	
	
}
