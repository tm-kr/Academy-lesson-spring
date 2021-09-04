package spring.di.ui;

import spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {
	
	private Exam exam;
	
	
	public GridExamConsole() {
	}

	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.println("ㅣㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅣ");
		System.out.println("ㅣ  total   ㅣ      avg   ㅣ");
		System.out.println("ㅣㅡㅡㅡㅡㅡㅡ ㅣㅡㅡㅡㅡㅡㅡ  ㅣ");
		 System.out.printf("ㅣ    %3d    ㅣ     %3.2f  ㅣ \n",exam.total(), exam.avg());
		System.out.println("ㅣㅡㅡㅡㅡㅡㅡ ㅣ ㅡㅡㅡㅡㅡㅡ ㅣ");
	}
	
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
