package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentTest {
    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");
        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);

        int parentId = DepartmentTest.getCommonParent(6, 7, allDepartment);
        System.out.println(parentId);
        parentId = DepartmentTest.getCommonParent(6, 8, allDepartment);
        System.out.println(parentId);
        parentId = DepartmentTest.getCommonParent(6, 3, allDepartment);
        System.out.println(parentId);
    }
    /**
     * 根据a,b 返回最近的父部门
     * 要求：不能新增参数，不能增加static变量
     *
     * @return
     */
    public static int getCommonParent(int a, int b, List<Department> allDepartment) {

        Map<Integer, Integer> id_Pid = allDepartment.stream().collect(Collectors.toMap(Department::getId, Department::getPid));
        Integer aPid = a;
        Integer bPid = b;

        if (a==b){
            return a;
        }

        while(aPid!=null&&bPid!=null){
            if (aPid==bPid){
                return aPid;
            }else if (aPid<bPid){
                bPid= id_Pid.get(bPid);
            }else {
                aPid = id_Pid.get(aPid);
            }
        }

        return aPid;

    }
    static class Department {
        /**
         * id
         */
        private int id;
        /**
         * parent id
         */
        private int pid;
        /**
         * 名称
         */
        private String name;
        public Department(int id, int pid, String name) {
            this.id = id;
            this.pid = pid;
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getPid() {
            return pid;
        }
        public void setPid(int pid) {
            this.pid = pid;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Department{" +
                    "id=" + id +
                    ", pid=" + pid +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
