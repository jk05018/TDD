package me.develop_han.TDD_start.proxypattern;

import java.util.ArrayList;
import java.util.List;

public class ThirdPartyYoutubeClass implements ThirdPartyYoutubeLib {

	@Override
	public List<Video> listVideos() {
		System.out.println("Send an API request to Youtube");
		return new ArrayList<>();
	}

	@Override
	public String getVideoInfo(long id) {
		System.out.println("Get metadata about some video.");
		return "";
	}

	@Override
	public Video downloadVedio(long id) {
		System.out.println("Download a video file from YouTube.");
		return new Video(1L, "video");
	}
}
