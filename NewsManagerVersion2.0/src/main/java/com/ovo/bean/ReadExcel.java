package com.ovo.bean;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    //总行数
    private int totalRows = 0;

    //总条数
    private int totalCells = 0;

    //错误信息接收器
    private String errorMsg;

    //构造方法
    public ReadExcel(){}

    //得到总行数
    public int getTotalRows()  { return totalRows;}

    //得到总列数
    public int getTotalCells() {  return totalCells;}

    public String getErrorInfo() { return errorMsg; }

    /**
     * 验证Excel文件
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath){
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))){
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }


    /**
     * 读Excel文件
     * @return
     */
    public List<Users> getExcelInfo(String fileName, MultipartFile Mfile){

        //把spring文件上传的MultipartFile转换成File
        CommonsMultipartFile cf= (CommonsMultipartFile)Mfile;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
        File file = fi.getStoreLocation();

        List<Users> userlist =new ArrayList<Users>();
        InputStream is = null;
        try{
            //验证文件名是否合格
            if(!validateExcel(fileName)){
                return null;
            }
            //判断文件时2003版本还是2007版本
            boolean isExcel2003 = true;
            if(WDWUtil.isExcel2007(fileName)){
                isExcel2003 = false;
            }
            is = new FileInputStream(file);
            userlist =getExcelInfo(is, isExcel2003);
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(is !=null)
            {
                try{
                    is.close();
                }catch(IOException e){
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return userlist;
    }
    /**
     * 此方法两个参数InputStream是字节流。isExcel2003是excel是2003还是2007版本
     * @param is
     * @param isExcel2003
     * @return
     * @throws IOException
     */
    public  List<Users> getExcelInfo(InputStream is,boolean isExcel2003){

        List<Users> userlist=null;
        try{
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = null;
            //当excel是2003时
            if(isExcel2003){
                wb = new HSSFWorkbook(is);
            }
            else{
                wb = new XSSFWorkbook(is);
            }
            userlist = readExcelValue(wb);
        }
        catch (IOException e)  {
            e.printStackTrace();
        }
        return userlist;
    }
    /**
     * 读取Excel里面的信息
     * @param wb
     * @return
     */
    private List<Users> readExcelValue(Workbook wb){
        //得到第一个shell
        Sheet sheet=wb.getSheetAt(0);

        //得到Excel的行数
        this.totalRows=sheet.getPhysicalNumberOfRows();

        //得到Excel的列数(前提是有行数)
        if(totalRows>=1 && sheet.getRow(0) != null){
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
        }

        List<Users> userlist =new ArrayList<Users>();
        Users users;           //用户的bean


        //循环Excel行数,从第二行开始。标题不入库
        for(int r=1; r<totalRows; r++)
        {
            Row row = sheet.getRow(r);
            if (row == null) continue;

            users=new Users();


            //循环Excel的列
            for(int c = 0; c <this.totalCells; c++)
            {
                Cell cell = row.getCell(c);
                if (null != cell)
                {
                	
                    //第一列
                    if(c==0){
                        //获得第一列<用户ID>
                        /**
                         * 处理：使用POI读excel文件，当遇到特殊格式的字串，比如“13612345678”，等等，
                         * 这样的本来是一个字符串，但是POI在读的时候总是以数值型识别，由此，这样的电话号码读出来后总是1.3XXX+E4
                         */
                        //DecimalFormat df = new DecimalFormat("#");
                        //String cellValue=df.format(cell.getNumericCellValue());
                    	cell.setCellType(Cell.CELL_TYPE_STRING);
                        users.setUsersId(cell.getStringCellValue());

                    }
                    //获得第二列<name>，放到到用户登录bean中。作为登录账号及密码
                    else if(c==1){
                    	cell.setCellType(Cell.CELL_TYPE_STRING);
                        users.setName(cell.getStringCellValue());
                    }
                    //第三列  mima
                    else if(c==2) {
                    	cell.setCellType(Cell.CELL_TYPE_STRING);
                        //DecimalFormat df = new DecimalFormat("#");
                        //String cellValue=df.format(cell.getNumericCellValue());
                        users.setPassword(cell.getStringCellValue());
                  }

                    //第四列描述 dianhuahao
                    else if(c==3){
                    	cell.setCellType(Cell.CELL_TYPE_STRING);
                    	//DecimalFormat df = new DecimalFormat("#");
                        //String cellValue=df.format(cell.getNumericCellValue());
                    	users.setPhoneNumber(cell.getStringCellValue());
                    }


                    //第五列 email
                    else if (c==4){
                    	cell.setCellType(Cell.CELL_TYPE_STRING);
                        users.seteMail(cell.getStringCellValue());
                    }

                    //第六列 sex
                    else if (c==5){
                    	cell.setCellType(Cell.CELL_TYPE_STRING);
                    	users.setSex(cell.getStringCellValue());
                    }

                    

                }
            }
            userlist.add(users);
        }
        return userlist;
    }
}
/**
 * @描述：工具类
 * 检验是否是EXCEL文件
 */
class WDWUtil
{
    // @描述：是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //@描述：是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}
