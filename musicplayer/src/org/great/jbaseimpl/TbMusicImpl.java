package org.great.jbaseimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.great.jbasedao.JBaseDao;
import org.great.jbean.TbMusic;
import org.great.util.DBUtil;

public class TbMusicImpl implements JBaseDao {

	@Override
	public List<?> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TbMusic> list = null;
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement("select * from tb_music");
			rs=ps.executeQuery();
			if(rs.next()){
				list=new ArrayList<TbMusic>();
				do{
					list.add(new TbMusic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
				}while(rs.next());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.release(rs, ps, conn);
		}
		return list;
	}
	
	@Override
	public boolean deleteBean(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertBean(Object bean) {
		TbMusic music=(TbMusic)bean;//获取传入的一条音乐数据
		Connection conn=null;
		PreparedStatement ps=null;
		boolean insert=false;
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement("insert into tb_music(music_name,music_size,music_time,music_path) values (?,?,?,?)");
			ps.setString(1, music.getMusic_name());
			ps.setString(2, music.getMusic_size());
			ps.setString(3, music.getMusic_time());
			ps.setString(4, music.getMusic_path());
			
			int rs=ps.executeUpdate();
			if(rs>0){
				insert=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insert;
	}

	@Override
	public boolean updateBean(Object bean) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean selectSong(String name) {//判断该路径上的歌曲是否存在
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean list = false;
		try {
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement("select * from tb_music where music_name=?");
			ps.setString(1, name);
			rs=ps.executeQuery();
			if(rs.next()){
				list=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.release(rs, ps, conn);
		}
		return list;
	}
	
}
