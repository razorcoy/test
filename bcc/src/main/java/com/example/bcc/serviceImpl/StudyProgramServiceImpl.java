package com.example.bcc.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bcc.model.StudyProgram;
import com.example.bcc.repository.StudyProgramRepository;
import com.example.bcc.service.StudyProgramService;

@Service
public class StudyProgramServiceImpl implements StudyProgramService {

	@Autowired
	StudyProgramRepository studyProgramRepo;

	@Override
	public List<StudyProgram> getAllStudyProgram() {
		List<StudyProgram> result = studyProgramRepo.findAll();
		return result;
	}

	@Override
	public String addStudyProgram(StudyProgram studyProgram){
		String result = "Add Study Program Failed";
		
		if(studyProgram != null) {
			studyProgramRepo.save(studyProgram);
			result = "Add Study Program Success";
		} 
		
		return result;
	}

	@Override
	public String updateStudyProgram(StudyProgram studyProgram) {
		String result = "Update Study Program Failed";
		
		Optional<StudyProgram> optStudyProgram = studyProgramRepo.findById(studyProgram.getKodePs());
		
		if(optStudyProgram.isPresent()) {
			studyProgramRepo.save(studyProgram);
			result = "Update Study Program Success";
		}
		
		return result;
	}

	@Override
	public String deleteStudyProgram(Integer kodePs) {
		String result = "Delete Study Program Failed";
		
		Optional<StudyProgram> optStudyProgram = studyProgramRepo.findById(kodePs);
		
		if(optStudyProgram.isPresent()) {
			studyProgramRepo.deleteById(kodePs);
			result = "Delete Study Program Success";
		}
		
		return result;
	}
	
	

}
