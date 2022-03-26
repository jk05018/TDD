package me.develop_han.TDD_start.proxypattern;

import java.util.List;

public interface ThirdPartyYoutubeLib {
	List<Video> listVideos();
	String getVideoInfo(long id);
	Video downloadVedio(long id);
}
