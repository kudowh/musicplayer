package org.great.jbean;

public class TbMymusic {
	int my_id;
	String type_id;
	String music_id;
	public int getMy_id() {
		return my_id;
	}
	public TbMymusic(int my_id, String type_id, String music_id) {
		super();
		this.my_id = my_id;
		this.type_id = type_id;
		this.music_id = music_id;
	}
	public void setMy_id(int my_id) {
		this.my_id = my_id;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getMusic_id() {
		return music_id;
	}
	public void setMusic_id(String music_id) {
		this.music_id = music_id;
	}
}
