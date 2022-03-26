package me.develop_han.TDD_start.proxypattern;

import java.util.List;

public class CachedYoutubeClass implements ThirdPartyYoutubeLib{
	private ThirdPartyYoutubeClass service;
	private List<Video> listCache;

	private String videoCache;

	public CachedYoutubeClass(ThirdPartyYoutubeClass service) {
		this.service = service;
	}

	@Override
	public List<Video> listVideos() {
		if(listCache == null){
			listCache = service.listVideos();
		}
		return listCache;
	}

	@Override
	public String getVideoInfo(long id) {
		if(videoCache == null){
			videoCache = service.getVideoInfo(id);
		}
		return videoCache;
	}

	@Override
	public Video downloadVedio(long id) {
		return service.downloadVedio(id);
	}
}
