package course;

public class Course {
    private String name;
    private String mainTeacher;
    private String assistantTeacher;
    private String status;
    private String timeAndClassroom;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return  name +"\t\t"+ timeAndClassroom+"\t"+ mainTeacher +"\t"+ assistantTeacher;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMainTeacher() {
		return mainTeacher;
	}
	public void setMainTeacher(String mainTeacher) {
		this.mainTeacher = mainTeacher;
	}
	public String getAssistantTeacher() {
		return assistantTeacher;
	}
	public void setAssistantTeacher(String assistantTeacher) {
		this.assistantTeacher = assistantTeacher;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimeAndClassroom() {
		return timeAndClassroom;
	}
	public void setTimeAndClassroom(String timeAndClassroom) {
		this.timeAndClassroom = timeAndClassroom;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((assistantTeacher == null) ? 0 : assistantTeacher.hashCode());
		result = prime * result
				+ ((mainTeacher == null) ? 0 : mainTeacher.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((timeAndClassroom == null) ? 0 : timeAndClassroom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (assistantTeacher == null) {
			if (other.assistantTeacher != null)
				return false;
		} else if (!assistantTeacher.equals(other.assistantTeacher))
			return false;
		if (mainTeacher == null) {
			if (other.mainTeacher != null)
				return false;
		} else if (!mainTeacher.equals(other.mainTeacher))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (timeAndClassroom == null) {
			if (other.timeAndClassroom != null)
				return false;
		} else if (!timeAndClassroom.equals(other.timeAndClassroom))
			return false;
		return true;
	}
	
	public void setAttribute(String param,int i){
		if(i==1){
			setName(param);//设置课程名称
		}else if(i==2){
			setTimeAndClassroom(param);
		}else if(i==3){
			setMainTeacher(param);
		}else if(i==4){
			setAssistantTeacher(param);
		}else if(i==8){
			setStatus(param);
		}
	}
}
