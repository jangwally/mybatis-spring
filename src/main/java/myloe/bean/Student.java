package myloe.bean;

import java.io.Serializable;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table student
 */
public class Student implements Serializable {
    /**
     * Database Column Remarks:
     * 学生ID
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * Database Column Remarks:
     * 学生姓名
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     * 性别
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.sex
     *
     * @mbg.generated
     */
    private Integer sex;

    /**
     * Database Column Remarks:
     * 班级ID
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.class_id
     *
     * @mbg.generated
     */
    private Integer classId;

    private Integer vision;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.id
     *
     * @return the value of student.id
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.id
     *
     * @param id the value for student.id
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.name
     *
     * @return the value of student.name
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.name
     *
     * @param name the value for student.name
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.sex
     *
     * @return the value of student.sex
     * @mbg.generated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.sex
     *
     * @param sex the value for student.sex
     * @mbg.generated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.class_id
     *
     * @return the value of student.class_id
     * @mbg.generated
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.class_id
     *
     * @param classId the value for student.class_id
     * @mbg.generated
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getVision() {
        if(this.vision==null){
            return 0;
        }
        return vision;
    }

    public void setVision(Integer vision) {
        this.vision = vision;
    }
}