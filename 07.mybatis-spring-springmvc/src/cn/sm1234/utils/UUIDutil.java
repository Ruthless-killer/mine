package cn.sm1234.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UUIDutil {
	public static String getUuid(){
		UUID uuid = UUID.randomUUID();
		String uuidStr =  uuid.toString();
    	uuidStr = uuidStr.replace("-", "");
    	return uuidStr;
	}
	public static List<Integer> getRandomNumList(int nums,int start,int end){
        //1.创建集合容器对象
        List list = new ArrayList();

        //2.创建Random对象
        Random r = new Random();
        //循环将得到的随机数进行判断，如果随机数不存在于集合中，则将随机数放入集合中，如果存在，则将随机数丢弃不做操作，进行下一次循环，直到集合长度等于nums
        while(list.size() != nums){
            int num = r.nextInt(end-start) + start;
            if(!list.contains(num)){
                list.add(num);
            }
        }

        return list;
    }

	
	
	public static void main(String[] args) {
		System.out.println(UUIDutil.getUuid()); 
	}

}
