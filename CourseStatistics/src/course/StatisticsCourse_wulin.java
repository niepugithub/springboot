package course;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class StatisticsCourse_wulin {

    static Set<String> teacherNames = new HashSet<>();

    private static Map<String, Teacher> getTeacherMaps() {
        List<Teacher> teachers = new ArrayList<>();
        Map<String, Teacher> teacherMaps = new HashMap<>();
        // 添加老师或者删除老师有三处需要修改：其中mapsToList()方法容易忘！！！
        Teacher teacher1 = new Teacher("Lima_jin");
//        Teacher teacher2 = new Teacher("Angel_hu");
        Teacher teacher3 = new Teacher("Lily_zou");
//        Teacher teacher4 = new Teacher("Molly_li");
        //static Teacher teacher5 = new Teacher("Icey_peng"); // 8.25 离职
        // static Teacher teacher6 = new Teacher("Rita_zhang");// 离职
        Teacher teacher7 = new Teacher("Vicky_chen");
        Teacher teacher8 = new Teacher("Tina_tang");
        // static Teacher teacher9 = new Teacher("Sherry_xu");// 离职
//	static Teacher teacher10 = new Teacher("Summer_qiu");
        Teacher teacher11 = new Teacher("Jenny_liu");
        Teacher teacher12 = new Teacher("Yoyo_feng");
        // 新增的老师
        Teacher teacher13 = new Teacher("Mia_gu");
        Teacher teacher14 = new Teacher("grace_wang");
        Teacher teacher15 = new Teacher("Chenchen_Chen");
        Teacher teacher16 = new Teacher("Carl_Lu");
        //static Teacher teacher17 = new Teacher("jucy_cai");// 8.25 离职
        //static Teacher teacher18 = new Teacher("jonlin_chen");// 8.25 离职

        Teacher teacher19 = new Teacher("lemon_zhang");
        Teacher teacher20 = new Teacher("elva_hao");
        //	static Teacher teacher21 = new Teacher("cherry_yang");
        // 乌克兰老师
//        Teacher teacher22 = new Teacher("illia_zuiko");
//        Teacher teacher23 = new Teacher("olya_luniakina");
        Teacher teacher24 = new Teacher("Alla_cui");
        Teacher teacher25 = new Teacher("Merle_liu");
        Teacher teacher26 = new Teacher("coco_zhao");
        Teacher teacher27 = new Teacher("alaia_zhao");
        Teacher teacher28 = new Teacher("Alli_hu");
        Teacher teacher29 = new Teacher("Kiki_zhong");
        Teacher teacher30 = new Teacher("Mars_feng");
        Teacher teacher31 = new Teacher("Stacy_wu");


        teachers.add(teacher1);
//        teachers.add(teacher2);
        teachers.add(teacher3);
//        teachers.add(teacher4);
        //teachers.add(teacher5);
        teachers.add(teacher7);
        teachers.add(teacher8);
//		teachers.add(teacher10);
        teachers.add(teacher11);
        teachers.add(teacher12);
        teachers.add(teacher13);
        teachers.add(teacher14);
        teachers.add(teacher15);
        teachers.add(teacher16);
        //teachers.add(teacher17);
        //teachers.add(teacher18);
        teachers.add(teacher19);
        teachers.add(teacher20);
//		teachers.add(teacher21);
//        teachers.add(teacher22);
//        teachers.add(teacher23);
        teachers.add(teacher24);
        teachers.add(teacher25);
        teachers.add(teacher26);
        teachers.add(teacher27);
        teachers.add(teacher28);
        teachers.add(teacher29);
        teachers.add(teacher30);
        teachers.add(teacher31);
        for (Teacher t : teachers) {
            teacherMaps.put(t.getName(), t);
        }
        return teacherMaps;
    }

    /**
     * 更改记录：
     * 2019-12-17：删掉Molly_li illia_zuiko olya_luniakina 在Kiki_zhong后面加上Mars_feng，在Mars_feng后面加上Stacy_wu
     *
     * @param args
     */
    public static void main(String[] args) {
        String path = "D:\\wf\\5.7\\5.12.xls";
        String des = "D:\\wf\\5.7\\5.12统计结果.xls";

//        String prefix = "D:\\wf\\6.1\\6.";
        String prefix = "D:\\wf\\武林\\2019-12-";
//        String prefix = "D:\\wf\\2019-11-01\\2019-11-";
        String suffix = ".xls";
        int startDate = 17;
        int days = 5;
        deal(prefix, suffix, startDate, days);

    }

    public static void deal(String prefix, String suffix, int startDate, int days) {
        for (int i = 1; i <= days; i++) {
            String path = prefix + startDate + suffix;
            String des = prefix + startDate++ + "统计结果-武林" + suffix;
            Set<Course> courseSet = getAllCourses(path);
            List<Teacher> teacherList = mapsToList(statisticCourse(courseSet, getTeacherMaps()));
            List2Excel.write2Excel(teacherList, des, "sheet0");
        }
    }

    private static List<Teacher> mapsToList(Map<String, Teacher> teacherMaps) {
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacherMaps.get("Yoyo_feng"));
        teacherList.add(teacherMaps.get("Lima_jin"));
//        teacherList.add(teacherMaps.get("Angel_hu"));
        teacherList.add(teacherMaps.get("Lily_zou"));
//        teacherList.add(teacherMaps.get("Molly_li"));
        //teacherList.add(teacherMaps.get("Icey_peng"));// 8.25离职
        // teacherList.add(teacherMaps.get("Rita_zhang"));//离职
        teacherList.add(teacherMaps.get("Vicky_chen"));
        teacherList.add(teacherMaps.get("Tina_tang"));
        // teacherList.add(teacherMaps.get("Summer_qiu"));
        teacherList.add(teacherMaps.get("Jenny_liu"));
        // 下面是新增加的老师
        teacherList.add(teacherMaps.get("Mia_gu"));
        teacherList.add(teacherMaps.get("grace_wang"));
        //teacherList.add(teacherMaps.get("Chenchen_Chen"));
        teacherList.add(teacherMaps.get("Carl_Lu"));
        //teacherList.add(teacherMaps.get("jucy_cai"));// 8.25 离职
        //teacherList.add(teacherMaps.get("jonlin_chen"));// 8.25 离职

        // 2018年9月4号新加
        teacherList.add(teacherMaps.get("lemon_zhang"));
        teacherList.add(teacherMaps.get("elva_hao"));
        // teacherList.add(teacherMaps.get("cherry_yang"));
        // 2019-03-14新增老师
        teacherList.add(teacherMaps.get("Alla_cui"));
        // 2018-11-22新增乌克兰老师
//        teacherList.add(teacherMaps.get("illia_zuiko"));
//        teacherList.add(teacherMaps.get("olya_luniakina"));
        teacherList.add(teacherMaps.get("coco_zhao"));
        teacherList.add(teacherMaps.get("Merle_liu"));
        teacherList.add(teacherMaps.get("alaia_zhao"));
        teacherList.add(teacherMaps.get("Alli_hu"));
        teacherList.add(teacherMaps.get("Kiki_zhong"));
        teacherList.add(teacherMaps.get("Mars_feng"));
        teacherList.add(teacherMaps.get("Stacy_wu"));

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
