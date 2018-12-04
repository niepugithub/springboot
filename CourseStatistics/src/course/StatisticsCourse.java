package course;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

public class StatisticsCourse {
	public static List<Teacher> teachers = new ArrayList<>();
	public static Map<String, Teacher> teacherMaps = new HashMap<>();
	private static Set<String> teacherNames = new HashSet<>();
	// 添加老师或者删除老师有三处需要修改：其中mapsToList()方法容易忘！！！
	static Teacher teacher1 = new Teacher("Lima_jin");
	static Teacher teacher2 = new Teacher("Angel_hu");
	static Teacher teacher3 = new Teacher("Lily_zou");
	static Teacher teacher4 = new Teacher("Molly_li");
	//static Teacher teacher5 = new Teacher("Icey_peng"); // 8.25 离职
	// static Teacher teacher6 = new Teacher("Rita_zhang");// 离职
	static Teacher teacher7 = new Teacher("Eric_luo");
	static Teacher teacher8 = new Teacher("Tina_tang");
	// static Teacher teacher9 = new Teacher("Sherry_xu");// 离职
	static Teacher teacher10 = new Teacher("Summer_qiu");
	static Teacher teacher11 = new Teacher("Jenny_liu");
	static Teacher teacher12 = new Teacher("Yoyo_feng");
	// 新增的老师
	static Teacher teacher13 = new Teacher("Mia_gu");
	static Teacher teacher14 = new Teacher("grace_wang");
	static Teacher teacher15 = new Teacher("Chenchen_Chen");
	static Teacher teacher16 = new Teacher("Carl_Lu");
	//static Teacher teacher17 = new Teacher("jucy_cai");// 8.25 离职
	//static Teacher teacher18 = new Teacher("jonlin_chen");// 8.25 离职

	static Teacher teacher19 = new Teacher("lemon_zhang");
	static Teacher teacher20 = new Teacher("vera_fan");
	static Teacher teacher21 = new Teacher("cherry_yang");
	// 乌克兰老师
	static Teacher teacher22 = new Teacher("illia_zuiko");
	static Teacher teacher23 = new Teacher("olya_luniakina");

	static {
		teachers.add(teacher1);
		teachers.add(teacher2);
		teachers.add(teacher3);
		teachers.add(teacher4);
		//teachers.add(teacher5);
		teachers.add(teacher7);
		teachers.add(teacher8);
		teachers.add(teacher10);
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
		teachers.add(teacher21);
		teachers.add(teacher22);
		teachers.add(teacher23);
		for (Teacher t : teachers) {
			teacherMaps.put(t.getName(), t);
		}
	}

	public static void main(String[] args) {
		String path = "D:\\wf\\11.22\\18.xls";
		String des = "D:\\wf\\11.22\\18统计结果.xls";
		Set<Course> courseSet = getAllCourses(path);
//		System.out.println(courseSet.size() + "====================");
		// for(Course s: courseSet){
		// if(s.getName().contains("基础")){
		// System.out.println(s);
		// }
		// }
		statisticCourse(courseSet, teacherMaps);
		List<Teacher> teacherList = mapsToList(teacherMaps);
		List2Excel.write2Excel(teacherList, des, "sheet0");
	}

	private static List<Teacher> mapsToList(Map<String, Teacher> teacherMaps) {
		List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(teacherMaps.get("Yoyo_feng"));
		teacherList.add(teacherMaps.get("Lima_jin"));
		teacherList.add(teacherMaps.get("Angel_hu"));
		teacherList.add(teacherMaps.get("Lily_zou"));
		teacherList.add(teacherMaps.get("Molly_li"));
		//teacherList.add(teacherMaps.get("Icey_peng"));// 8.25离职
		// teacherList.add(teacherMaps.get("Rita_zhang"));//离职
		teacherList.add(teacherMaps.get("Eric_luo"));
		teacherList.add(teacherMaps.get("Tina_tang"));
		teacherList.add(teacherMaps.get("Summer_qiu"));
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
		teacherList.add(teacherMaps.get("vera_fan"));
		teacherList.add(teacherMaps.get("cherry_yang"));
		// 2018-11-22新增乌克兰老师
		teacherList.add(teacherMaps.get("illia_zuiko"));
		teacherList.add(teacherMaps.get("olya_luniakina"));

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
						System.out.println(param+"+++++++");
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
