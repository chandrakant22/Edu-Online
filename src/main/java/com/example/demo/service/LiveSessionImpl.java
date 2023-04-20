package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LiveSession;
import com.example.demo.repository.LiveSessionRepository;


@Service
public class LiveSessionImpl implements LiveSessionService{

	@Autowired
	private LiveSessionRepository liveSessionRepo;
	
	@Override
	public List<LiveSession> getAllLiveSession() {
		return liveSessionRepo.findAll();
	}

	@Override
	public void saveLiveSession(LiveSession t) {
		liveSessionRepo.save(t);
	}

	@Override
	public void deleteLiveSession(LiveSession t) {
		liveSessionRepo.delete(t);
	}

	@Override
	public Optional<LiveSession> getLiveSessionById(int id) {
		return liveSessionRepo.findById(id);
	}
	

}
