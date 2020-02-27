package course;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class List2Excel {
    //	  private int musicEnlightenmentLesson;//音乐启蒙课
//    private int pianoMusicFoundationMain;//钢琴音乐基础课（主课）
//    private int pianoMusicFoundation;//钢琴音乐基础课（助课）
//    private int pianoPerformance30;//演奏课（30分钟）
//    private int pianoPerformance50;//演奏课（50分钟）
//    private int VIP50;//VIP
//    private int makeUp50;//补课（50分钟）
//    private int makeUp30;//补课（30分钟）
    public static void write2Excel(List<Teacher> listArg, String path, String sheetName) {
        try {
            HSSFWorkbook newExcel = new HSSFWorkbook();// 创建excel
            Sheet newSheet0 = newExcel.createSheet(sheetName);// 创建一个sheet
            String[] title = {"指导老师", "时间", "钢琴体检大课（主）", "钢琴体检大课（助）", "音乐体验课（主）",
                    "音乐体验课（助）", "演奏试听小课", "测评课",
                    "音乐启蒙课 ", "钢琴音乐基础（主）", "钢琴音乐基础（助）", "钢琴演奏（30分）", "钢琴演奏（50分）",
                    "VIP课（50分）", "补/调课（30分钟）", "补/调课（50分钟）", "合计", "课时费总计"};// 表头
            Row newRow0 = newSheet0.createRow(0);// 创建表头
            int i = 0;
            for (String s : title) {// 写入表头
                Cell cell = newRow0.createCell(i++);
                cell.setCellValue(s);
            }
            i -= title.length;
            Map<String, Integer> feeMap;
            for (int m = 0; m < listArg.size(); m++) {
                Teacher t = listArg.get(m);
                feeMap = CourseFee.getCourseFeeMap(t.getGrade());
                int totalFee = 0;
                Row newRow = newSheet0.createRow(++i);
                for (int j = 0; j < title.length - 1; j++) {
                    Cell cell = newRow.createCell(j);
                    try {
                        // 这里可以获取相应的课时名称和数量
                        int courseCount = Integer.parseInt(t.getAttribute(j));
                        Integer singleCountFee = feeMap.get(title[j]);
                        if (Objects.isNull(singleCountFee)) {
                            System.out.println("课程没有统计到==========" + title[j]);
                        }
                        totalFee += courseCount * singleCountFee;
                        cell.setCellValue(courseCount);
                    } catch (Exception e) {
                        cell.setCellValue(t.getAttribute(j));
                    }
                }
                // 这列加上课时费
                Cell cell = newRow.createCell(title.length - 1);
                cell.setCellValue(totalFee);
            }
            FileOutputStream out = new FileOutputStream(path);
            newExcel.write(out);//保存Excel文件
            out.close();//关闭文件流
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("写list到excel出错啦");
        }
    }
}
