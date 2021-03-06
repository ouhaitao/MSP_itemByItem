package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;

import po.Item;
import provider.ItemPro;

public interface ItemMapper {

	/**
	 * @param param key是数据库的列,value是用于查询的值
	 * 				查询价格时输入一个区间,priceLeft为低价,priceRight为高价
	 * 可通过商品编号(id),创建时间(time),名字(name),期望(except),分类(classfication),价格(price),uid查询商品
	 */
	@SelectProvider(method="select",type=ItemPro.class)
	public List<Item> select(Map<String, String> param);
	
	@Insert("insert into tb_item values(#{id},#{time},#{name},#{detail},#{img},#{expect},#{classification},#{price},#{uid})")
	public int add(Item i);
	
	@Delete("delete from tb_item where id=#{id}")
	public int delete(Item i);
	
	/**
	 * @param param key是数据库的列,value是要修改的值
	 * 				必须传入item的主键,即必须传入id
	 * 可用于修改商品名字(name),详细信息(detail),图片(img),期望(except),分类(classfication),价格(price)
	 */
	@SelectProvider(method="update",type=ItemPro.class)
	public int Update(Map<String, Object> param);
}
