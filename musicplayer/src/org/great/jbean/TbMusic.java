package org.great.jbean;

public class TbMusic {
	int music_id;
	String music_name;
	String music_time;
	String music_path;
	String music_size;
	public String getMusic_size() {
		return music_size;
	}
	public void setMusic_size(String music_size) {
		this.music_size = music_size;
	}
	public int getMusic_id() {
		return music_id;
	}
	public TbMusic(int music_id, String music_name,String music_size, String music_time, String music_path) {
		super();
		this.music_id = music_id;
		this.music_name = music_name;
		this.music_size=music_size;
		this.music_time = music_time;
		this.music_path = music_path;
		
	}
	public void setMusic_id(int music_id) {
		this.music_id = music_id;
	}
	public String getMusic_name() {
		return music_name;
	}
	public void setMusic_name(String music_name) {
		this.music_name = music_name;
	}
	public String getMusic_time() {
		return music_time;
	}
	public void setMusic_time(String music_time) {
		this.music_time = music_time;
	}
	public String getMusic_path() {
		return music_path;
	}
	public void setMusic_path(String music_path) {
		this.music_path = music_path;
	}
	
}
