package course;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class StatisticsCourse_chengxi {

    static Set<String> teacherNames = new HashSet<>();

    private static Map<String, Teacher> getTeacherMaps() {
        List<Teacher> teachers = new ArrayList<>();
        Map<String, Teacher> teacherMaps = new HashMap<>();
        // 添加老师或者删除老师有三处需要修改：其中mapsToList()方法容易忘！！！
        Teacher teacher1 = new Teacher("Angel_hu");
        Teacher teacher2 = new Teacher("Eric_luo");
        Teacher teacher3 = new Teacher("Lulu_zhao");
        Teacher teacher4 = new Teacher("Niko_wang");

        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);

        for (Teacher t : teachers) {
            teacherMaps.put(t.getName(), t);
        }
        return teacherMaps;
    }

    public static void main(String[] args) {
        String path = "D:\\wf\\5.7\\5.12.xls";
        String des = "D:\\wf\\5.7\\5.12统计结果.xls";

        String prefix = "D:\\wf\\武林\\2019-11-";
//        String prefix = "D:\\wf\\2019-11-01\\2019-11-";
        String suffix = ".xls";
        int startDate = 12;
        int days = 4;
        deal(prefix, suffix, startDate, days);

    }

    public static void deal(String prefix, String suffix, int startDate, int days) {
        for (int i = 1; i <= days; i++) {
            String path = prefix + startDate + suffix;
            String des = prefix + startDate++ + "统计结果-城西" + suffix;
            Set<Course> courseSet = getAllCourses(path);
            List<Teacher> teacherList = mapsToList(statisticCourse(courseSet, getTeacherMaps()));
            List2Excel.write2Excel(teacherList, des, "sheet0");
        }
    }

    private static List<Teacher> mapsToList(Map<String, Teacher> teacherMaps) {
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacherMaps.get("Angel_hu"));
        teacherList.add(teacherMaps.get("Eric_luo"));
        teacherList.add(teacherMaps.get("Lulu_zhao"));
        teacherList.add(teacherMaps.get("Niko_wang"));
        return teacherList;
    }

    private static Set<Course> getAllCourses(String path) {
        Set<Course> courseSet = new HashSet<>();
        File file = new File(path);
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheet("sheet0");
            int rows = sheet.getLastRowNum();// 获取excel表的行数
            int columns = sheet.getRow(0).getLastCellNum();// 获取excel表的列数
            for (int i = 1; i <= rows; i++) {// 从表的第2行开始读取数据，第一行是表头；
                Row row = sheet.getRow(i);// 获取特定的行，开始读取数据，封装成Car
                Course course = new Course();
                for (int j = 0; j < columns; j++) {// 第0列开始读取数据
                    HSSFCell cell = (HSSFCell) row.getCell(j);
                    String param = cell.getStringCellValue();
                    course.setAttribute(param, j);
                    if (j == 3 || j == 4) {
                        teacherNames.add(param);
                    }
                    if (i == 9 && j == 1) {
                        System.out.println(param + "+++++++");
                    }
                }
                if ((course.getName().contains("音乐启蒙课")
                        || course.getName().contains("钢琴音乐基础课") || course
                        .getName().contains("钢琴基础"))
                        && courseSet.contains(course)) {
                    if (!course.getStatus().equals("请假")
                            && !course.getStatus().equals("旷课")) {
                        getCourseFromSet(courseSet, course).setStatus(
                                course.getStatus());
                    }
                }
                courseSet.add(course);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return courseSet;
    }

    private static Map<String, Teacher> statisticCourse(Set<Course> courseSet,
                                                        Map<String, Teacher> maps) {
        for (Course course : courseSet) {
            String courseName = course.getName();
            String mainTeacher = course.getMainTeacher();
            String assitantTeacher = course.getAssistantTeacher();
            String status = course.getStatus();
            if ((!courseName.contains("钢琴音乐基础课") && !courseName
                    .contains("钢琴基础课"))
                    && (!status.equals("请假"))
                    && (!status.equals("旷课"))) {
                System.out.println(courseName + "===========================");
                if (maps.containsKey(mainTeacher)) {
                    maps.get(mainTeacher).addMainCourse(courseName);
                }
            } else if ((courseName.contains("钢琴音乐基础课") || courseName
                    .contains("钢琴基础课"))
                    && (!status.equals("请假"))
                    && (!status.equals("旷课"))) {
                if (maps.containsKey(mainTeacher)) {
                    maps.get(mainTeacher).addMainCourse(courseName);
                }
                if (maps.containsKey(assitantTeacher)) {
                    maps.get(assitantTeacher).addAssistCourse(courseName);
                }
            }
        }
        return maps;
    }

    private static Course getCourseFromSet(Set<Course> set, Course course) {
        for (Course cou : set) {
            if (cou.equals(course)) {
                return cou;
            }
        }
        return null;
    }
}
