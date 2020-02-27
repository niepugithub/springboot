package course;

import java.util.HashMap;
import java.util.Map;

/**
 * @date:2020/2/27 14:57
 **/
public abstract class CourseFee {
    // 课时费
    private static Map<TeacherGradeEnum, Map<String, Integer>> mapMap = new HashMap<>();

    static {
        mapMap.put(TeacherGradeEnum.manager, getManagerMap());
        mapMap.put(TeacherGradeEnum.high, getHighMap());
        mapMap.put(TeacherGradeEnum.middle, getMiddleMap());
        mapMap.put(TeacherGradeEnum.back_middle, getBackMiddleMap());
        mapMap.put(TeacherGradeEnum.junior, getJuniorMap());
        mapMap.put(TeacherGradeEnum.practice, getPracticeMap());
        mapMap.put(TeacherGradeEnum.foreign, getManagerMap());
    }


    public static Map<String, Integer> getManagerMap() {
        Map<String, Integer> managerMap = new HashMap<>();
        managerMap.put("钢琴体检大课（主30分）", 50);
        managerMap.put("钢琴体检大课（助30分）", 30);
        managerMap.put("音乐体验课（主30分）", 50);
        managerMap.put("音乐体验课（助30分）", 30);
        managerMap.put("体验小课（体验，测评30分）", 30);/////////////////有换行符啊
        managerMap.put("音乐启蒙课（50分）", 70);
        managerMap.put("钢琴音乐基础（主50分）", 50);
        managerMap.put("钢琴基础（助50分）", 40);
        managerMap.put("钢琴演奏（30分）", 40);/////////////////有换行符啊
        managerMap.put("钢琴演奏（50分", 90);/////////////////有换行符啊
        managerMap.put("VIP课（50分）", 90);
        managerMap.put("补/调课（30分钟", 40);
        managerMap.put("补/调课（50分钟）", 90);
        managerMap.put("W7-W10(50分钟大课）", 90);
        managerMap.put("W7-W10(50分钟小课）", 90);
        managerMap.put("W7-W10补/调课（30分钟）", 40);
        managerMap.put("W7-W10补/调课（50分钟）", 90);
        return managerMap;
    }

    public static Map<String, Integer> getHighMap() {
        Map<String, Integer> highMap = new HashMap<>();
        highMap.put("钢琴体检大课（主30分）", 50);
        highMap.put("钢琴体检大课（助30分）", 30);
        highMap.put("音乐体验课（主30分）", 50);
        highMap.put("音乐体验课（助30分）", 30);
        highMap.put("体验小课（体验，测评30分）", 30);/////////////////有换行符啊
        highMap.put("音乐启蒙课（50分）", 70);
        highMap.put("钢琴音乐基础（主50分）", 50);
        highMap.put("钢琴基础（助50分）", 40);
        highMap.put("钢琴演奏（30分）", 40);/////////////////有换行符啊
        highMap.put("钢琴演奏（50分", 90);/////////////////有换行符啊
        highMap.put("VIP课（50分）", 90);
        highMap.put("补/调课（30分钟", 40);
        highMap.put("补/调课（50分钟）", 90);
        highMap.put("W7-W10(50分钟大课）", 90);
        highMap.put("W7-W10(50分钟小课）", 90);
        highMap.put("W7-W10补/调课（30分钟）", 40);
        highMap.put("W7-W10补/调课（50分钟）", 90);
        return highMap;
    }

    public static Map<String, Integer> getMiddleMap() {
        Map<String, Integer> middleMap = new HashMap<>();
        middleMap.put("钢琴体检大课（主30分）", 50);
        middleMap.put("钢琴体检大课（助30分）", 30);
        middleMap.put("音乐体验课（主30分）", 50);
        middleMap.put("音乐体验课（助30分）", 30);
        middleMap.put("体验小课（体验，测评30分）", 30);/////////////////有换行符啊
        middleMap.put("音乐启蒙课（50分）", 70);
        middleMap.put("钢琴音乐基础（主50分）", 50);
        middleMap.put("钢琴基础（助50分）", 40);
        middleMap.put("钢琴演奏（30分）", 40);/////////////////有换行符啊
        middleMap.put("钢琴演奏（50分", 70);/////////////////有换行符啊
        middleMap.put("VIP课（50分）", 70);
        middleMap.put("补/调课（30分钟", 40);
        middleMap.put("补/调课（50分钟）", 70);
        middleMap.put("W7-W10(50分钟大课）", 50);
        middleMap.put("W7-W10(50分钟小课）", 50);
        middleMap.put("W7-W10补/调课（30分钟）", 40);
        middleMap.put("W7-W10补/调课（50分钟）", 50);
        return middleMap;
    }

    public static Map<String, Integer> getBackMiddleMap() {
        Map<String, Integer> backMiddleMap = new HashMap<>();
        backMiddleMap.put("钢琴体检大课（主30分）", 50);
        backMiddleMap.put("钢琴体检大课（助30分）", 30);
        backMiddleMap.put("音乐体验课（主30分）", 50);
        backMiddleMap.put("音乐体验课（助30分）", 30);
        backMiddleMap.put("体验小课（体验，测评30分）", 30);/////////////////有换行符啊
        backMiddleMap.put("音乐启蒙课（50分）", 70);
        backMiddleMap.put("钢琴音乐基础（主50分）", 50);
        backMiddleMap.put("钢琴基础（助50分）", 40);
        backMiddleMap.put("钢琴演奏（30分）", 40);/////////////////有换行符啊
        backMiddleMap.put("钢琴演奏（50分", 70);/////////////////有换行符啊
        backMiddleMap.put("VIP课（50分）", 70);
        backMiddleMap.put("补/调课（30分钟", 40);
        backMiddleMap.put("补/调课（50分钟）", 70);
        backMiddleMap.put("W7-W10(50分钟大课）", 50);
        backMiddleMap.put("W7-W10(50分钟小课）", 50);
        backMiddleMap.put("W7-W10补/调课（30分钟）", 40);
        backMiddleMap.put("W7-W10补/调课（50分钟）", 50);
        return backMiddleMap;
    }

    public static Map<String, Integer> getJuniorMap() {
        Map<String, Integer> juniorMap = new HashMap<>();
        juniorMap.put("钢琴体检大课（主30分）", 50);
        juniorMap.put("钢琴体检大课（助30分）", 30);
        juniorMap.put("音乐体验课（主30分）", 50);
        juniorMap.put("音乐体验课（助30分）", 30);
        juniorMap.put("体验小课（体验，测评30分）", 30);/////////////////有换行符啊
        juniorMap.put("音乐启蒙课（50分）", 70);
        juniorMap.put("钢琴音乐基础（主50分）", 50);
        juniorMap.put("钢琴基础（助50分）", 40);
        juniorMap.put("钢琴演奏（30分）", 40);/////////////////有换行符啊
        juniorMap.put("钢琴演奏（50分", 50);/////////////////有换行符啊
        juniorMap.put("VIP课（50分）", 50);
        juniorMap.put("补/调课（30分钟", 40);
        juniorMap.put("补/调课（50分钟）", 50);
        juniorMap.put("W7-W10(50分钟大课）", 50);
        juniorMap.put("W7-W10(50分钟小课）", 50);
        juniorMap.put("W7-W10补/调课（30分钟）", 40);
        juniorMap.put("W7-W10补/调课（50分钟）", 50);
        return juniorMap;
    }

    public static Map<String, Integer> getPracticeMap() {
        Map<String, Integer> practiceMap = new HashMap<>();
        practiceMap.put("钢琴体检大课（主30分）", 50);
        practiceMap.put("钢琴体检大课（助30分）", 30);
        practiceMap.put("音乐体验课（主30分）", 50);
        practiceMap.put("音乐体验课（助30分）", 30);
        practiceMap.put("体验小课（体验，测评30分）", 30);/////////////////有换行符啊
        practiceMap.put("音乐启蒙课（50分）", 70);
        practiceMap.put("钢琴音乐基础（主50分）", 50);
        practiceMap.put("钢琴基础（助50分）", 40);
        practiceMap.put("钢琴演奏（30分）", 40);/////////////////有换行符啊
        practiceMap.put("钢琴演奏（50分", 50);/////////////////有换行符啊
        practiceMap.put("VIP课（50分）", 50);
        practiceMap.put("补/调课（30分钟", 40);
        practiceMap.put("补/调课（50分钟）", 50);
        practiceMap.put("W7-W10(50分钟大课）", 50);
        practiceMap.put("W7-W10(50分钟小课）", 50);
        practiceMap.put("W7-W10补/调课（30分钟）", 40);
        practiceMap.put("W7-W10补/调课（50分钟）", 50);
        return practiceMap;
    }

    public static Map<String, Integer> getCourseFeeMap(TeacherGradeEnum gradeEnum) {
        return mapMap.get(gradeEnum);
    }

}
