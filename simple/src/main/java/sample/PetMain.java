package sample;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sample.domain.Pet;

public class PetMain {
	public static void main(String[] args) throws IOException{
		//1
		String resource = "META-INF/mybatis.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlMapper.openSession();
		//2
		Pet pet = session.selectOne("sample.dao.petMapper.selectPet",1);
		session.close();
		System.out.println(pet.getPetId());
		System.out.println(pet.getPetName());
		
	}

}
