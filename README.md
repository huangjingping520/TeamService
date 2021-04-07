# TeamService

A practice java project

## 一、创建项目基本组件
### 基本步骤
1. 创建TeamService项目
2. 创建相应的包(domain、service、view)
3. 在domain包中创建Equipment接口并实现子类代码
4. 在domain包中创建Employee类及其子类代码
5. 检验代码正确性

### 键盘访问的实现
通过view包中的TSUtility.java类

`public static char readMenuSelection()`
读取键盘，如果用户键入'1'~'4'中的任意字符，则方法返回该用户输入字符

`public static void readReturn()`
提示并等待，直到用户按回车键后返回

`public static int readInt()`
从键盘读取一个不超过2位的整数，并将其作为方法的返回值。

`public static char readConfirmSelection()`
从键盘读取'Y'或'N'，并将其作为方法的返回值

### Equipment 接口及其实现子类的设计
1. 说明
    - model 表示机器的型号
    - display 表示显示器名称
    - type 表示机器的类型
2. 根据需要提供个属性的get/set方法以及重载构造器
3. 实现类实现接口的方法，返回各自属性的信息