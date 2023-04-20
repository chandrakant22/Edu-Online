package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.LiveSession;



public interface LiveSessionService {

	List <LiveSession> getAllLiveSession();
	void saveLiveSession(LiveSession t);
	void deleteLiveSession(LiveSession t);
	Optional <LiveSession> getLiveSessionById(int id);
}
