package jvm.student;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;

/**
 * 使用对象的软连接 softReference实现对象的高速缓存
 * @author kingdee
 * http://zhangjunhd.blog.51cto.com/113473/53092
 */
public class StudentCache {
	
	static private StudentCache cache;
	
	private Hashtable<Integer, StudentRef> students;
	
	private ReferenceQueue<Student> refs;
	
	private StudentCache(){
		students = new Hashtable<>();
		refs = new ReferenceQueue<>();
	}
	
	public static StudentCache getInstance(){
		if(cache==null){
			cache = new StudentCache();
		}
		return cache;
	}
	
	private class StudentRef extends SoftReference<Student>{
		private Integer id;
		public StudentRef(Student s,ReferenceQueue<Student> r) {
			super(s,r);
			id = s.getId();
		}
	} 
	public void cacheStudent(Student s){
//		cleanCache();
		StudentRef ref = new StudentRef(s, refs);
		students.put(s.getId(), ref);
	}
	
	public Student getStudent(Integer id){
		Student s = null;
		if(students.contains(id)){
			s = students.get(id).get();
		}
		if(s==null){
			s = new Student();
			s.setId(5);
			s.setName("sjy");
			s.setGender("male");
			cacheStudent(s);
		}
		return s;
	}
	
	
 	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
