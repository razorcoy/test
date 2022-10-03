package com.example.bcc.service;

import java.util.List;
import com.example.bcc.model.StudyProgram;


public interface StudyProgramService {
	
	public List<StudyProgram> getAllStudyProgram();
	
	public String addStudyProgram(StudyProgram studyProgram);
	
	public String updateStudyProgram(StudyProgram studyProgram);
	
	public String deleteStudyProgram(Integer kodePs);

}
