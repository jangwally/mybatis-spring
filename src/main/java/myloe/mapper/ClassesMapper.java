package myloe.mapper;

import java.util.List;
import myloe.bean.Classes;

public interface ClassesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    int insert(Classes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    Classes selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    List<Classes> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classes
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Classes record);
}