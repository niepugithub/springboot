package course;

public class Teacher {
    private int musicEnlightenmentLesson;//音乐启蒙课
    private int pianoMusicFoundationMain;//钢琴音乐基础课（主课）
    private int pianoMusicFoundation;//钢琴音乐基础课（助课）
    private int pianoPerformance30;//演奏课（30分钟）
    private int pianoPerformance50;//演奏课（50分钟）
    private int VIP50;//VIP
    private int makeUp50;//补课（50分钟）
    private int makeUp30;//补课（30分钟）
    private String name;

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "老师 [音乐启蒙课=" + musicEnlightenmentLesson
                + ", 钢琴音乐基础课（主课）=" + pianoMusicFoundationMain
                + ", 钢琴音乐基础课（助课）=" + pianoMusicFoundation
                + ", 演奏课（30分钟）=" + pianoPerformance30
                + ", 演奏课（50分钟）=" + pianoPerformance50 + ", VIP50="
                + VIP50 + ", 补课（50分钟）=" + makeUp50 + ", 补课（30分钟）=" + makeUp30 + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMusicEnlightenmentLesson() {
        return musicEnlightenmentLesson;
    }

    public void setMusicEnlightenmentLesson(int musicEnlightenmentLesson) {
        this.musicEnlightenmentLesson = musicEnlightenmentLesson;
    }

    public int getPianoMusicFoundationMain() {
        return pianoMusicFoundationMain;
    }

    public void setPianoMusicFoundationMain(int pianoMusicFoundationMain) {
        this.pianoMusicFoundationMain = pianoMusicFoundationMain;
    }

    public int getPianoMusicFoundation() {
        return pianoMusicFoundation;
    }

    public void setPianoMusicFoundation(int pianoMusicFoundation) {
        this.pianoMusicFoundation = pianoMusicFoundation;
    }

    public int getPianoPerformance30() {
        return pianoPerformance30;
    }

    public void setPianoPerformance30(int pianoPerformance30) {
        this.pianoPerformance30 = pianoPerformance30;
    }

    public int getPianoPerformance50() {
        return pianoPerformance50;
    }

    public void setPianoPerformance50(int pianoPerformance50) {
        this.pianoPerformance50 = pianoPerformance50;
    }

    public int getVIP50() {
        return VIP50;
    }

    public void setVIP50(int vIP50) {
        VIP50 = vIP50;
    }

    public int getMakeUp50() {
        return makeUp50;
    }

    public void setMakeUp50(int makeUp50) {
        this.makeUp50 = makeUp50;
    }

    public int getMakeUp30() {
        return makeUp30;
    }

    public void setMakeUp30(int makeUp30) {
        this.makeUp30 = makeUp30;
    }

    //	 private int musicEnlightenmentLesson;//音乐启蒙课
//	 private int pianoMusicFoundationMain;//钢琴音乐基础课（主课）
//	 private int pianoMusicFoundation;//钢琴音乐基础课（助课）
//	 private int pianoPerformance30;//演奏课（30分钟）
//	 private int pianoPerformance50;//演奏课（50分钟）
//	 private int VIP50;//VIP
//	 private int makeUp50;//补课（50分钟）
//	 private int makeUp30;//补课（30分钟）
    public void addMainCourse(String courseName) {
        if (courseName.equals("演奏课（50分钟）")) {
            this.pianoPerformance50 += 1;
        } else if (courseName.equals("演奏课（30分钟）")) {
            this.pianoPerformance30 += 1;
        } else if (courseName.equals("钢琴音乐基础课")) {
            this.pianoMusicFoundationMain += 1;
        } else if (courseName.contains("音乐启蒙课")) {
            this.musicEnlightenmentLesson += 1;
        } else if (courseName.equals("VIP")) {
            this.VIP50 += 1;
        } else if (courseName.equals("补课（50分钟）")) {
            this.makeUp50 += 1;
        } else if (courseName.equals("补课（30分钟）")) {
            this.makeUp30 += 1;
        }
    }

    public void addAssistCourse(String courseName) {
        if (courseName.equals("钢琴音乐基础课")) {
            this.pianoMusicFoundation += 1;
        }
    }

    public String getAttribute(int j) {
        if (j == 0) {
            return name;
        } else if (j == 8) {//等于8返回音乐启蒙课
            return getMusicEnlightenmentLesson() + "";
        } else if (j == 9) {//等于9返回钢琴音乐基础主
            return getPianoMusicFoundationMain() + "";
        } else if (j == 10) {//等于10返回钢琴音乐基础助
            return getPianoMusicFoundation() + "";
        } else if (j == 11) {//等于11返回钢琴演奏30分钟
            return getPianoPerformance30() + "";
        } else if (j == 12) {//等于12返回钢琴演奏50分钟
            return getPianoPerformance50() + "";
        } else if (j == 13) {//等于13返回VIP50分钟
            return getVIP50() + "";
        } else if (j == 14) {//等于14补课30分钟
            return getMakeUp30() + "";
        } else if (j == 15) {//等于15补课50分钟
            return getMakeUp50() + "";
        } else if (j == 16) {//等于16返回合计
            return getTotal() + "";
        }
        return "";
    }

    public int getTotal() {
        int temp = 0;
        temp = getMakeUp30() + getMakeUp50() + getMusicEnlightenmentLesson() + getPianoMusicFoundation();
        temp += getPianoPerformance30() + getPianoPerformance50() + getVIP50() + getPianoMusicFoundationMain();
        return temp;
    }
}
