# 代码结构

写了好多代码，用过很多框架后，还记得一个`.java`文件的构成吗？

## 基本结构

```java
public class 类名{

	public static void main(String[] args)
	{
		//代码块
	}
}
```

## 软件包[package]

语法：

```java
package 包名;
//包名就是由字母、数字、_，不以数字开头的字符字符序列。
//多级包名之间使用.隔开，如：
package java.lang;
package a.b.c.d.e.f.g;//ok
```

命名规则：

```java
A)、一般以公司域名为前半部分，如：`com.ali.xx.xx.xx;`		`com.aiz.xx.xx;`
B)、以项目名和功能划分为后半部分，如：`com.ali.crm.servive;`		`com.aiz.se.day01;`
```

包的作用；
包名在编译完成后生产的字节码中，会有对应的目录结构。
所以，它可以很好地管理源文件和字节码。
她还扩展了类的命名空间。
如：有一个类都叫:`Date`
那我们可以把它存放在不同的包中，如:
`java.util.Date;`
`java.sql.Date;`
这两个类的名字[简名]虽然不一样，但是处在不同的包中，是可行的。
他们的全限定名是不一样的，因为全限定名是 包名.类名。

## 导入语句[import]

* 语法：

```java
import 包名.类名|*;
```

* 支持通配，只能通配类名，不能通配包名。
* 可以写多次。
* 何时需要使用导入语句？	
  当一个类中需要使用非本包中的其他类时，则需要使用导入语句。
  除非”目标类“是在`java.lang`下。

## 注释[commets]

* 是为了增加代码的可读性、理解性的一种手段，JVM的编译器是会忽略他的。

* Java语言支持三种注释：

```java
A、单行注释，以//开头
B、多行注释，以/*开头，以*/结尾
C、文档多行注释，以/**开头，以**/结尾
	如：
	/**
	*XXXX
	*XXXX
	*XXXX
	*/
这种注释，将来可以通过javadoc命令来提取。
```



# 数据类型

废话不多说，在`Java`中数据类型分为两大类：基本类型和对象类型。

## 基本类型(8种)

|  类型   | 占用字节 | 取值范围                                         |
| :-----: | :------: | ------------------------------------------------ |
|  byte   | 1个字节  | [-128,+127]                                      |
|  short  | 2个字节  | [-32,768，+32,767]                               |
|   int   | 4个字节  | [-2,147,483,648，+2,147,483,647] [-2^31,+2^31-1] |
|  long   | 8个字节  | [-2^63,+2^63-1] 10^19                            |
|  char   | 2个字节  | 一种特殊的整数，范围同short                      |
| double  | 8个字节  | 10^308                                           |
|  float  | 4个字节  | 10^38                                            |
| boolean | 1个字节  | 只有2个值，true和false                           |


* 在Java中，最高位代表符号位，1为负，0为正。以8位二进制为例，所以：

|   二进制   | 十进制 |
| :--------: | :----: |
| 0 000 0000 |   0    |
| 0 111 1111 |  +127  |
| 1 000 0000 |  -128  |
| 1 111 1111 |   -1   |

## 对象类型

所有不是基本类型的都是对象类型，如：`String`、`System`...所以，我们编写程序，也就是不断地创建类型。因为我们想表达我们要表达的数据。下面介绍三种常用的对象类型。

### 字符串

#### 定义

有关字符串类型，`java.lang.String` 类，它的本质就是`char[]`,它的实现代码：

```java
public final class String implements CharSequence{
	private char[] content;
	private int capacity;
	private int index;
	//...
}
```

也就是说，字符串就是由字符数组组成的。但是，String是不变类，它的实例也就是不变对象。

如：

```java
String s1 = new String("abc");//一旦这个字符串生成，则就是不可变的。
s1 = "def";//ok,这是新建了字符串def ,原来abc 会被GC回收
```

对于字符串而言，它是最常用的数据，所以，JVM针对它做了特殊处理；其次，专门有一个“串池”的内存空间来存放`String实例`，但是，字符串实例是否存放在串池中要由程序员的定义决定。

#### 创建字符串

创建字符串的实例有如下两种方式:

1. 普通方式[在堆空间中]

```java
String s1 = new String("abc");//ok
String s2 = new String("abc");//ok

System.out.println(s1 == s2);//false
```

2. 串池方式

```java
String s3 = "abc";//ok
String s4 ="abc";//ok

System.out.println(s3 == s4);//true

s4 = "xyz";//此时，会在串池中重新申请空间并存放 xyz,并把地址赋给s4
```

由于字符串是不变对象，所以，它的每一次拼接都会产生临时对象。

```java
String s5 = "abc" + "def" + "xyz";//abcdefxyz
```

这个代码会产生5个对象，其中，2个临时对象。s5是引用，是地址。

所以，考虑到字符串的性能问题，`JDK`提供了`StringBuilder`拼接工作，它利用一个可变字符串数组来进行拼接。

#### StringBuilder和StringBuffer

`StringBuilder`和`StringBuffer`这两个类的区别：

> 1.StringBuffer是多线程安全的类
> 2.StringBuilder是多线程不安全的类

本质上这两个类的功能一模一样，唯一不同的就是`StringBuffer`的所以方法都是同步的[synchronized]。

建议大家使用`StringBuilder`,因为大多数时候我们的环境都是单线程环境的。
即使是多线程环境，我们也可以自己加同步代码块来保证`StringBuilder`的多线程安全。

#### 常用方法

```java
int length();//获取长度
boolean isEmpty();//判空
char charAt(int index);//根据位置获取字符
byte[] getBytes();//转化为字节数组
boolean equals(Object anObject);//判等
boolean startsWith(String prefix);//是否以prefix为前缀
int indexOf(int ch);//ch第一次在原字符串中出现的位置
String substring(int beginIndex, int endIndex);//获取子串
String concat(String str);//拼接
String replace(char oldChar, char newChar);//替换
String[] split(String regex, int limit);//分割
//...
```

可以参考官网api，地址：https://docs.oracle.com/javase/8/docs/api/java/lang/String.html。

#### 字符的编解码操作

> 编码：把字符转换成字节的过程
> 解码：把字节转换成字符的过程

每一个字符背后都是一个整数[byte也是一种整数]，所以，不同的字符集采用不同长度的编码，如：

> ASCII 采用单字节
> GBK 采用双字节编码
> UTF-8 采用多字节[1~3]

如：

```java
String name = "张三丰";
//把此字符进行编码
byte[] arr = name.getBytes();//默认字符集
//
byte[] arr = name.getByte("UTF-8");

//也可以解码
String str = new Strin(arr);//默认字符集
String str = new String(arr,"UTF-8");//...

//有关字符串的切割	--split方法
String str = "abc:def:::haha:heihei::";
String[] arr = str.split(":");
```

#### 正则表达式

定义：就是一些有“特殊”功能的字符序列。
早先，JAVA并不支持正则表达式，从`JDK1.4`开始，引入了`java.util.regex`包，开始正式支持正则。

如何使用正则：

> 1.先把正则表达式[字符串]编译成Pattern实例
> 2.利用Pattern提供的方法或者进一步得到Matchr
> 3.利用Matcher进行匹配

如：

```java
String regex = "a";
Pattern p = Pattern.compile(regex);//把这个字符串[正则]编译成Pattern实例
String str = "aaaab";//准备你要测试的字符串
Matcher m = p.matcher(str);//得到Matceher对象

//str.matches(regex);
//Pattern.matches(regex,str);

//接下来就可以使用Matcher的方法
m.matches(); 匹配一次，成功为true,否则为false
m.find();//依次去尝试匹配多次
m.group();//配合find使用
m.start();//配合find,匹配成功的起始位置
m.end();//配合find,匹配成功的最后位置
//...
```

### 日期

```java
java.util.Date
	\- java.sql.Date [专门针对数据库的数据类型]
Date的构造
	public Date();
	public Date(long millis);
```

注：在计算机中日期是使用一个长整型来表示的，它规定从1970年1月1日午夜开始到现在所经过的毫秒数。
通过` System.currentTimeMillils()` 方法来获取这个值。
利用这个值可以来构建一个Date实例。

#### 构建Date实例

如：

```java
Date now = new Date(); //
//2个小时前
Date now2 = new Date(
	System.currentTimeMillils()-2*60*60*1000);
```

构建一个 `2008-8-8号`? 怎么办？这就需要利用下面的`Calendar`类。

```
java.util.Calendar
	\- java.util.GregorianCalendar
```

```java
//Code
Calendar cal = new GregiroanCalendar();
//但是不推荐这么做，因为使用了具体的子类，而应该：
Calendar cal = Calendar.getInstance();

//得到了日历类，就可以对它进行操作
//1. 可以修改时间 [通过长整型修改或通过修改年、月、日]
cal.set(Calendar.YEAR,2008);
cal.set(Calendar.MONTH,7);
cal.set(Calendar.DAY_OF_MONTH,12)

//2. 可以获取时间
Date now = cal.getTime();

//3.获取单个值 
int year = cal.get(Calendar.YEAR);
..
int month = cal.get(Calendar.MONTH);

int week = cal.get(Calendar.DAY_OF_WEEK);
//注：返回的值是1~7， 1代表周日，7代表周六
```

#### 日期的格式化

```java
java.text.DateFormat
	\- java.text.SimpleDateFormat
```

由于`DateFormat`中内置工厂方法的格式不符合我们的使用，所以，此处我们直接使用 `SimpleDateFormat`。

```java
DateFormat df = DateFormat.getInstance();
//但是：
String p = "yyyy-MM-dd";
SimpleDateFormat sdf = new SimpleDateFormat(p);
//现在，就可以利用sdf来格式化或解析一个字符串
如：
String str = "2008-08-8";
Date d1 = sdf.parse(str);
//
Date now = new Date();
String str2 = sdf.format(now); //2017-07-20
```

### 数字类

数字操作

包装类[Wrapper]，也就是针对8种基本类型而言的。

| 基本类型 | 包装类型  |
| :------: | :-------: |
|   byte   |   Byte    |
|  short   |   Short   |
|   int    |  Integer  |
|   long   |   Long    |
|  double  |  Double   |
|  float   |   Float   |
|   char   | Character |
| boolean  |  Boolean  |

包装类就是基本类型的对象类型，并且基本类型与对应的包装类型之间可以自动解封箱。也就是它们之间可以自动转换。
如：

```java
int i = 9;
Integer j = i;//自动封箱[auto boxing]
int k = j;//自动解箱[auto unboxing]

short s =19;
int i = s;//ok

Short s1 = new Short(19);
int i1 = s1;///ok
```

#### 字符串与数字之间的转换

```java
String iStr = "19";
Integer i = new Integer(iStr);//ok
//然后
int ii = i.intValue();//int ii = i; //ok

//或者利用parseInt方法
int k = Integer.parseInt(iStr);

int r = 119;
//String rStr = r +"";
//
String rStr = String.valueOf(r);
```

#### 大数字类型

> java.math.BigInteger	大整数
> java.math.BigDecimal	大浮点数

原有的数字范围所不能表达的，就需要使用大数字。
如：

```java
int i = 9;
int j = 19;
int k = i + j;

//换成大数据对象的计算：
BigInteger i = new BigInteger("9");
BigInteger j = new BigInteger("19");
BigInteger k = i.add(j);
```

#### 数字的格式化 [美化数字]

数字和字符串之间的转换。
如：
`1358.6  => ￥1,358.6`
以上的这个美化靠 String.valueOf做不到，需要使用NumberFormat 来进行。

## 变量常量字面量

### 变量

变量，variable，是一种可以变化的量。
语法：

```java
数据类型 变量名 [= 初始值];			[]代表可以省略
变量名，由字母、数字、_组成，并且不能以数字开头。
如：i,a,ai,haha,a5...

注：给变量命名时尽可能地有意义[见名知意]

如：定义一个变量来存储年龄
int age;//变量没有初始化
age = 10;//给变量赋值

以上两行语句也可以合在一起：
int age = 10;

//定义一个长整型变量，并初始化为100.
long a = 100L; //长整型字面量以L或l结尾

//定义一个浮点数变量
double height = 176.5;

//单精度浮点
float weight = 68.5F;//以F或f结尾
```

### 常量

常量[literal]，是不变的变量。
语法：

```java
final 数据类型 常量名 = 初始值;
如：
int i = 100;
i = 90;//ok
final int J =  200;//常量
J = 230；//error
注：
常量名一般采用大写字母。
如：
final String MSG = "hahaha";
```

### 字面量

字面量[constant]，“双引号括起来的”，就是字面本身的量。

```java
只有8种基本类型以及字符串String才有字面量。
如：1,4,5,100L，true,false,'a',"abc";

作用：用来给变量或者常量赋值。
```

### 相关知识

#### 了解计算机存储数据的方式

```java
计算机存储数据的方式采用二进制【由0和1组成】
规定每8位为一个字节。
这样，1个字节所能表达的状态有：2^8=256 种
```

#### 有关字符的表达方式

在Java中，字符使用单引号括起来，它有如下三种表达方式：
A.普通表达方式，每对单引号中只能有唯一的字符。

```java
char c1 = 't';
```

B.特殊字符表达式[使用转义符转义过的]

```java
char c3 = '\t';//制表符
这类特殊字符有：
'\r'	回车
'\n'	换行
'\''	单引号
'\\'	反斜杠
'\"'	双引号
...
```

C.采用`UNICODE`字符表示法

```java
语法：'\u 4位16进制表示法'
如：
char c1 = '我';
改成unicode表示法：
char c1 = '\u6211';
通过jdk提供的 native2ascii.exe命令可以把任意的中文转换成unicode字符码
ctrl + C 退出
```

字符是一种特殊的整数。
Java采用双字节编码，就意味着它可以表达 2 ^ 16 = 65536 个字符

在计算机中，要存储字符，都需要把字符转换成整数，进而成为二进制。这就需要字符映射表，也就是码表【字符集表】。
计算机中最原始的字符集是`ASCII码表`，不同的码表对字符的码表是不一样的，其中，`ASCII码表`采用单字节编码，也就是它最多可编256个字符。

| 字符 | 码值 |
| ---- | ---- |
| 'a'  | 97   |
| 'z'  | 122  |
| 'A'  | 65   |
| 'Z'  | 90   |
| '0'  | 48   |
| '9'  | 57   |

中文字符集采用双字节编码，但是，为了向上兼容`ASCII`码值，前256的值与`ASCII`码一模一样，这样就兼容了`ASCII码表`。【所有主流的字符集都会无条件向上兼容`ASCII码表`】
中文字符集：
	`GB2312`->`GBK`
全球统一的字符集：
	`UTF-8`	[支持中文]，它采用动态编码技术。

所以，当文本文件的编解码不一致时，就会产生乱码。

## 类型转换

* 隐式类型转换
  当小范围变量、字面量赋值给大范围变量时发生。如：

```java
byte b1 = 12;
int i = b1;//ok
char c = 'a';
i = c;//ok，结果是 97
```

* 显示类型转换【强制类型转换】
  当大范围变量、字面量赋值给小范围变量时发生。
  语法：(新类型）变量或者表达式或者字面量

```java
int i = 97;
char c = i;//error,有可能丢失精度
char c = (char)i;//ok,做了强制类型转换
```





# 运算符、表达式、分支语句、循环语句

## 运算符

### 赋值运算符

`=`
左值，出现在赋值运算符左边的量【局部变量、常量】
右值，出现在赋值运算符右边的量【局部变量、常量、字面量】

### 算术运算符

`+,-,*,/,%,++,--,+=,-=,*=,/=,%=`

针对++和——运算符，它分为：`前` 和 `后` 操作
前++，变量本身和表达式的值都增1.
后++，表达式的值不变，变量本身的值增1.
Java基本数据类型中，除了`boolean`不能做算术运算外，其它的7种类型都可以进行算术运算，它们遵守如下两条规则：
A.`byte,short,char,int`之间的运算，结果总是`int`
B.除A外规则，其他的按照从小到大的原则进行转换，如下：`byte,short,int ->long ->float ->double`

### 比较运算符

`>,<,>=,<=,==,!=`
比较运算符的结果一定是`boolean`值,如：

```java
boolean b = 5 > 3;
```

### 逻辑运算符

| 运算符 | 说明                                   |
| ------ | -------------------------------------- |
| `&&`   | 逻辑与，两边同时成立，结果才成立。     |
| `｜｜` | 逻辑或，两边同时不成立，结果才不成立。 |
| `!`    | 真为假，假为真                         |

注：逻辑运算符要求它的操作数必须是`boolean`类型。
如：`boolean b = (5 > 3) && (5 % 3 == 0);`
`&&` 和 `||` 是 <font color=red> 短路运算符</font>。

### 三目运算符

`？：`
语法：
	`expr1?exper2:exper3;`
当`expr1`成立时，则执行并返回`expr2`，否则，执行并返回`exper3`。

如：

```java
int i = 19;
String str = (i % 2 == 0) ? "偶数" : "奇数";
```

### 位运算符

#### 基本概念

| 运算符 | 说明                                           |
| ------ | ---------------------------------------------- |
| `&`    | 按位与，两边为1，结果为1，有一边为0，结果为0。 |
| `｜`   | 按位或，两边为0，结果为0，有一边为1，结果为1。 |
| `^`    | 按位异或，相同为0，不同为1。                   |
| `~`    | 按位取反，0位1,1为0。                          |
| `>>`   | 右移位，高位补符号位。                         |
| `>>>`  | 无符号右移位，高位总是补0。                    |
| `<<`   | 左移位                                         |

`&=,|=,^=,~=,>>=,>>>=,<<=`

```java

```



以整数为例，如：

二进制转十进制，乘幂相加法。

十进制转二进制，除2取余，直到商为0。

|  二进制   | 十进制 |
| :-------: | :----: |
|    10     |   2    |
|    11     |   3    |
|   10110   |   22   |
| 101111011 |  187   |


注：在Java中，支持二、八、十、十六进制的字面量，默认下，整数都是以十进制表达的。

```java
//如果你想用二进制表达整数，则需要以0b开头。
int i = 0b1011101;//ok

//如果你想用八进制表达整数，则需要以0开头。
int i = 015;//ok，相当于十进制13

//如果你想用十六进制表达整数，则需要以0x开头。
int i = 0x1F;//ok，相当于十进制的31
```

求负数的二进制方法：
1).先算 这个负数 绝对值 减1的 二进制。
2).按位取反：1111111111... 011  => 共计32位。

#### 位运算口诀

清0取位要用与，某位置1可用或，
若要取反和交换，轻轻松松用异或。

这个口诀中，关键要找到掩码[mask]

比如：
1.判断一个整数的奇偶性。

```java
//定义掩码：
int mask = 0x1;//00000...0001
int i = ...;
//判断
String iStr = (i & mask) == 0 ？"偶数" : "奇数";
```

2.高24位不变，低8位取反

```java
//定义掩码：
int mask = 0xFF;
int i = ...;
//判断
String iStr = mask ^ i;
//中间8位取反
//定义掩码：
int mask = 0xFF000;
int i = ...;
//判断
String iStr = mask ^ i;
```

3.一个整数连续异或另一个整数两次，其值不变。(最简单的加密)
如：

```java
int a = 18;//10010
int b = 21;//10101
//a ^ b ^ b 的结果将会还是 a
//交换a和b:
a = a ^ b;//a = a ^ b;
b = a ^ b;//b = b ^ a ^ b;//相当于a异或了b两次，回到b
a = a ^ b;//a = a ^ b ^ a;//相当于b异或了a两次，回到a
```

## 表达式[expression]

概念：由变量、常量、字面量与运算符组合成的合法语句。
如：

```java
int i = 9;//变量定义，也是 赋值表达式
int j = i * 2 + 1;
```

## 分支语句

### if语句

语法：

```java
if(条件表达式){
	//代码块
}
//或：
if(条件表达式){
	//代码块1
}
else{
	//代码块2
}
//或：
if(条件表达式){
	//代码块1
}if else(条件2){
	//代码块2
}if else(条件3){
	//代码块3
}else{
	//其他代码块...
}
```

举个栗子，如：

```java
int i = 9;
if((i & 1) == 0){
	System.out.println(i+" 是一个偶数.");
}else{
	System.out.println(i+" 是一个奇数.");	
}
```

### switch语句

语法：

```java
switch(变量因子){
case 值1：
	//代码块;
	[break;]
case 值2：
	//代码块;
	[break;]
...
case 值N：
	//代码块;
	[break;]
default:
	//默认代码块;
	[break;]
}
```

注：变量因子的数据类型只能是：`byte,short,char,int,枚举,Sting`。
举个栗子，如：

```java
int i = ...;
switch(i){
case 1:
	System.out.println("1");
	break;
case 2:
	System.out.println("2");
case 3:
	System.out.println("3");
	break;
case 4:
	System.out.println("4");
	break;
default:
	System.out.println("other");
}
```

## 循环语句

### for循环

语法：

```java
for(expr1;exper2;exper3){}
```

注：事先已经明确循环次数的场景下可以使用for循环。循环都可以嵌套。

举个栗子,如：

```java
//使用for循环来循环5次。
for(int i = 0; i<5;i++){
	
}
```

### while循环

语法：

```java
while(条件表达式){
	//循环体
}
```

比如，使用while循环5次

```java
int i = 0;
while(i<5){
	System.out.println("haha");
	i++;
}
```

注：
如果事先不知道循环次数，可以使用while语法。
如果事先明确知道循环次数，则建议使用for语法。

如：

```java
while(true){
	System.out.println("haha");
	//
	if(满足某个条件){
		break;//打破循环
	}
}
//或：【不适用break】
boolean exit = false;
while(!exit){
	System.out.println("haha");
	//
	if(满足某个条件){
		exit = true;//修改变量的值
	}
}
```

思考：在java中，如何生成随机数？

```java
方法一：利用java.util.Random类
//Code
Random r = new Random();
int i = r.nextInt(100) + 1;
方法二：利用java.lang.Math类
//
int i = (int)(Math.random()*100)+1;
```

### do while循环

语法：

```java
do{
	//循环体
}while(条件表达式);
```

它是一个先执行循环体而后做条件判断的循环。
如：

```java
int i = 0;
do{
	System.out.println("haha");
	i++
}while(i<5);
```

### break和continue语句

break语句，用来打破循环。
continue语句也是一样只能用在循环中，它是结束本轮循环，开始下一轮循环。

注：
不管是break还是continue语句，它们影响的都是最接近于自己那一层循环。

如：

```java
for(int i = 0;i<9;i++){
	if(i%3 == 0){
		break;
	}
	System.out.println("haha");
}
```



# 方法、修饰符、返回类型、参数列表、异常列表

## 方法[method name]

### 定义

方法[method]是类的成员之一，（因为在`java`中，方法不能单独定义，它必须在类之中）。

```java
修饰符 返回类型 方法名()[throws 异常类型]{
	//方法体
}
```

方法名字：只要是一个合法的名字就可以，尽可能有意义。
如：`getName`,`nextInt`...

### 调用

当被调用的方法使用static修饰符修饰时:

* 通过类名来调用，也就是：`ClassName.methodName();`如：

```java
double d = Math.sqrt(4.5);
String istr = Integer.toBinaryString(8);
```

当被调用的方法没有使用static修饰符修饰时:

* 通过对象来调用，也就是：`obj.methodName();`如：

```java
Scanner sc = new Scanner(System.in);
//此处的sc就是对象[变量]
int i = sc.nextInt();
```

`注`：在Java中，方法之间是没有顺序的。

/*
this 当前对象 
same class
context 上下文
一个静态方法不能直接调用非静态方法。所以要先创建对象。
*/

### 重载

在一个类中，具有相同方法名称但不同参数的方法就构成了方法的重载。
什么叫方法的重载？

* 参数个数不同

* 参数类型不同

* 参数顺序不同
  
  如：

```java
public class Demo{
	public int add(int a,int b){return a+b;}
	public double add(double a,double b){return a+b;}
	public double add(int a,double b){return a+b;}
	public double add(double a,int b){return a+b;}
}
```

当调用重载方法时，JVM是根据参数列表来判断出准确的方法的。

### 递归[recursive]

递归就是指方法直接或间接地调用自己。
利用递归可以用简单的程序来解决一些复杂的问题，比如：斐波那契数列的计算、汉诺塔问题、快排等问题。
递归结构包括两个部分：

1. 定义递归头。解答：什么时候不调用自身方法。如果没有头，将陷入死循环，也就是递归的结束条件。
2. 递归体。解答：什么时候需要调用自身方法。

如：求一个整数的阶乘。
`5! = 5*4!; 4! = 4*3!; 3! = 3*2!; 2! = 2*1!; 1! = 1;`
使用数学公式就可以表达为：`f(n) = n*f(n-1);`
所以，递归要有2个条件，也就是上面说的递归结构的两个部分。
一要有规律，二要有退出时机。

`注`：使用递归时方法的效率不是很高，它对栈的容量有较大的要求，因为每一次的调用都是利用栈来保存中间的计算结果，直到最后一次递归返回结果。
如果栈不够的话，则`JVM`会抛出`StackOverflowException`。

```java
/* 求阶乘方法 */
public static long factorial(int n){
	if(n==1){//递归头
		return 1L;
	}else{//递归体
		return factorial(n-1);//n! = n * (n-1)!
	}
}

/* 所有用递归可以实现的方法都可以使用非递归实现。 */
/* 非递归求阶乘方法 */
public static long factorialLoop(int n){
	long result = 1;
	while(n > 1){
		result *= n * (n-1);
		n -= 2;
	}
	return result;
}

/* 求整数的二进制字符串形式 */
public String toBinary(int n){
	if(n==0){//退出条件
		return "";
	}
	return toBinary(n/2)+n%2;
}

/* 汉诺塔问题 */
public void move(char a, char b, char c, int n) {
	//
	if(n == 1){
		System.out.println(a+" -> "+c);
	}
	//调用自己
	move(a, c, b, n-1);
	System.out.println(a + " -> "+c);
	//再调用自己
	move(b, a, c, n-1);
}

```

## 修饰符[modifier]

访问控制修饰符`piblic` ,`prootected`,`默认`,`private`
其他修饰符 `static,abstract,final,syschronized,native,volatile`...
注：修饰符之间是不没有顺序的。
在java中，针对类的成员访问限权有四种，分别对应四种修饰符。

|           | 全局 | 子类 | 同包 | 本身 |
| :-------: | :--: | :--: | :--: | :--: |
|  public   |  Y   |  Y   |  Y   |  Y   |
| protected |  N   |  Y   |  Y   |  Y   |
|   默认    |  N   |  N   |  Y   |  Y   |
|  private  |  N   |  N   |  N   |  Y   |


## 返回类型[return type]

1.所有合法的数据类型【包含基本数据类型和自定义对象】	

表示这个方法有返回值，则在代码体中必须有return语句，并返回与表示这个方法有一致类型的。
2.`void`
表示这个方法没用返回值，则在代码体中可以不写return语句，如果一定要写，只能写空返回，如：`return;`。

## 参数列表[parameters]

参数列表就是局部变量【Local variable】，它的语法与变量一样，只是不能初始化。
如有多个参数，则每个参数之间使用逗号隔开。

如：

```java
public int add(int a,int b){
	//...
}
```

当这个参数被调用[invoke]之时，它的参数才会有值【传递进来】。

所以，对于参数，有两种叫法：
形参，是在方法的定义时所叫，它只有类型，暂时无值。
实参，实在方法的调用时所叫，它既有类型又有值。

## 异常列表

### 异常定义

java异常[exception]定义：是一种“信号”传递机制。
如：

```java
int i = ...;
int j = ...;

if(i / j == ...) { //有可能会出现异常【除0异常】
	//...
}
//...
```

一段代码中，如果存在“有可能”出现异常的代码，而你的程序中又没有针对它做出“处理”，则一旦出现异常，程序就有可能会异常结束，从而达不到你的预期。

### 会有哪些异常？

java的异常可以分为：A. 运行时异常，也叫未检查异常；B. 非运行时异常,也叫已检查异常；

### 运行时异常，也叫未检查异常

所有直接或间接继承于`RuntimeException`异常的类都叫未检查异常，有：
`NullPointerException` 空指针异常
`ClassCastException`  类型转换异常
`ArrayIndexOutofBoundsException` 下标越界异常
...
以上这类异常都有一个共性：都是在JVM内部造成的，而不是由外部环境引起的。所以，这种异常可以说是由程序员编码粗心造成的。
解决方案是：希望程序员编码谨慎，比如：对象使用之前做非空判断，....

### 非运行时异常,也叫已检查异常

它们直接或间接继承于`Exception`类，或者换句话说，只要不是`RuntimeException`的子类，就是已检查异常。
如：
`IOException`,`SqlException`,`FileNotFoundException`,`NetException`, ...
以上这些异常也有一些共性，就是它们都是由JVM外部环境造成的，所以，对于此类异常，光编码谨慎是不够的，还有做出处理。

> 注：在java中，对异常还有更高层次的抽象，叫可抛出的，由`java.lang.Throwable`来表示。

```java
java.lang.Throwable
	\- java.lang.Error [错误] 无需处理它
	\- java.lang.Exception [异常] 重视
		  \- RuntimeException 未检查异常
	   \- 直接继承或间继承于 Exception 的类
```

### 如何处理异常？

有如下两种处理方式A. 消极处理方式，B. 积极处理方式。

#### 消极处理方式

利用 关键字 throws 把异常抛出。如：

```java
public void ma() throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    System.out.print("please enter int>");
    //
    int i = sc.nextInt(); //这个方法有可能会抛出异常的。
    //但是，由于是未检查异常，所以，可以不用处理。
    
    //...
    Thread.sleep(1000); //这个方法也是有可能会抛出异常的.
    //这个异常是已检查异常，所以，必需要做出处理
    //...
}
```

#### 积极处理方式

利用 try catch finally 语句块来处理这个语句块有多种不同的变种。如：

```java
try {
    //有可能出现异常的代码
    ...
} catch(异常类型 e) {
    //...做日志，或者可以恢复...
} catch (异常类型 e) {
    //...
}
```

还有：

```java
try {
    //有可能出现异常的代码
    ...

} catch(异常类型 e) {
    //...做日志，或者可以恢复...
} finally {
    //... 一般做释放资源
}
//....
```

注：不管try块中的代码是否出现了异常，`finally`块总会执行，除非在try块中执行了 

```java
System.exit(1)//退出JVM 进程
```

还有：

```java
try {
    //....
    ...
} finally {
    //...一般做释放资源
}
```

### 自定义异常类

自定义异常类一般是自定义已检查异常。只需要定义一个类继承 `java.lang.Exception` 类即可，并且重写父类的构造方法。

如：

```java
public class BalanceNotEnoughException extends Exception {
    public BalanceNotEnoughException() { super(); }

    public BalanceNotEnoughException(String msg) { super(msg); }

    public BalanceNotEnoughException(Throwable cause) { super(cause); }

    public BalanceNotEnoughException(String msg,Throable cause){
        super(msg,cause);
    }
}
```



# 数组

回顾一下自己刚刚开始认识数组的那会，还是感觉好神奇的，对着课本赞叹666。当然肯定是结合着实际场景才会体会到数组的美丽。这么聊吧，如果你想要存放全班同学的姓名，你怎么办？
如果没有接触过数组，我们一定想这样做：

```java
String name1 = "小A";
String name2 = "小B";
//...
String nameN = "小N";
```

但是，肯定不是这样啦！班级如果50人，这样搞你会炸掉的，哈哈哈哈。创造来源于需求，那么，下面就来走进数组的世界。

## 数组特点

* 具备相同的数据类型。
* 所有的数组元素共享同一个数组名字。
* 通过下标来访问元素，下标从0开始，到length-1结束。

## 数组定义

定义：数组是具有相同数据类型的一组数据集合。
语法：数据类型[] 数组名；
如：

```java
int[] iarr ;//仅仅是定义/声明 一个整型数组。
```

## 数组初始化

如何初始化一个数组？

首先，我们要记住，数组是对象类型。
所以，需要使用new运算符来初始化数组。
最后，要明确指定数组的初始化长度。
而且，长度一旦确定，是不可再变的。

如：

```java
int[] iarr = new int[100];
String[] names = new String[100];
//数组初始化后，它的每个元素都是默认值，其中：
byte,short,int,long =>0
double,float => 0.0
boolean => false
char => '\u0000'
对象类型 => null
```

## 数组操作

### 迭代数组

如何迭代一个数组？
1.普通for循环

```java
//Code:
int[] iarr = new int[10];
for(int i = 0;i<iarr.length;i++){
	System.out.println(iarr[i]);
}
```

2.增强for循环

```java
语法：
for(数据类型 e: 数组名字){
	//...
}
//Code:
int[] iarr = new int[10];
for(int e: iarr){
	System.out.println(e);
}
```

### 元素赋值

如何给数组元素赋值？
A.一个一个赋值

```java
//Code
String[] name = new String[3];
name[0] = "jack";
name[1] = "rose";
name[3] = "john";
```

B.在初始化时直接赋值。

```java
//Code
String[] names = new String[]{
	"jack","rose","john"
};
或：
String[] names = {"jack","rose","john"};
或：
String[] names;
names = {"jack","rose","john"};//error
names = new String[]{"jack","rose","john"};//ok
```

C.利用循环给元素赋值。
用来用在元素值是有“规律”的情况下。
如：

```java
int[] arr = new int[10];//想要在此数组中存放1~10
for(int i=1;i<=10;i++){
	arr[i]=i;
}
```

### 数组操作说明

数组是一种基本的数据结构[data structure]。有数据结构就会想到算法，它们相辅相成，最终目的为了数据存取的高效性。
对数据的操作，本质上可以归为：增、删、查、改。

## 二维数组

二维数组就是数组中的元素还是一维数组。

多维数组就是数组中的元素还是数组。

Java语言支持多维数组。

二维数组的定义：
数据类型[][] 数组名 = new 数据类型[rows][cols];
其中，在初始化二维数组时，rows必须要指定。而cols可以省略。

如果省略了cols，则表示只初始化了二维本身，而二维数组中的元素没有初始化。

如：

```java
int[][] arr = new int[3][]; 
//初始化了二维数组，但是它的元素[一维的]并没有初始化
```

所以，在初始化二维数时，如果指定了 cols，则这个二维数组我们说是规则的。
如

```java
int[][] arr = new int[n][m]; //

如果不指定cols，则可以实现不规则的二维组。
如：
int[][] brr = new int[n][]; //只初始化了二维
进一步去初始化它的每一个元素[一维]
brr[0] = new int[1];
brr[1] = new int[2];
brr[2] = new int[3];
...
brr[n-1] = new int[n];

int[][] crr = new int[][]{
	{1,2},
	{3,4},
};
```

# lambda表达式

## 概念

λ是希腊字母表中排序第十一位的字母，英语名称为lambda。为了避免匿名内部类定义过多，Java8引入这一新特性。其实质是函数式编程的概念。

## 语法格式

```
(params)->expression
(params)->statement
(params)->{statements}
```

## 借助Runnable推导演示

### 普通方式启动线程

比如创建线程时，我们只需要关注线程体(内容)，而不需要线程类和结构。先来看一下这个代码。

```java
package com.aiz.se.lambda;

/**
 * @Description 启动一个线程的一种方法
 * @Author ZhangYao
 */
public class StartRun implements Runnable {
    /**
     * 线程入口
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("喝酸奶");
        }
    }

    public static void main(String[] args) {
        new Thread(new StartRun()).start();
        for (int i = 0; i < 10; i++) {
            System.out.println("吃爆米花");
        }
    }

}
```

### 通过内部类

我们知道一个类如果只是使用一次，我们可以把这个类做成内部类。

```java
//静态内部类
static class InnerThread1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("喝酸奶");
		}
	}
}

public static void main(String[] args) {
	new Thread(new InnerThread1()).start();
}
```

### 通过局部内部类

其实我们可以把上面那个类中的类进行挪动，放在一个方法当中。

```java
public static void main(String[] args) {
	//局部内部类
	class InnerThread2 implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("喝酸奶");
			}
		}
	}
	new Thread(new InnerThread2()).start();
}
```

### 通过匿名内部类

```java
//匿名内部类 必须借助接口或者父类
new Thread(new Runnable() {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("喝酸奶");
		}
	}
}).start();
```

### jdk1.8 lambda

相比匿名内部类省略接口名和方法名，但是，这种方式接口里面只能有一个没有实现的方法。

```java
//jdk8使用lambda简化 省略接口名和方法名
new Thread(()->{
		for (int i = 0; i < 10; i++) {
			System.out.println("喝酸奶");
		}
	}
).start();
```

一般来说比较简单的线程体我们才使用lambda，lambda就是用于简化简单的线程体，jdk8会自己进行推导是Runnable的run()方法。接口中如果有多个没有实现的方法无法则进行推导。

### 推导总结

通过上面一步一步的推导，我想应该明白了lambda表达式创造的用意和如何进行使用。由于上面每个步骤的代码片段不在一起，下面先放一个总的代码类，方面直接观察。

```java
package com.aiz.se.lambda;

/**
 * @Description Lambda表达式简化线程(只用一次)的使用
 * @Author ZhangYao
 */
public class LambdaThread {
    //静态内部类
    static class InnerThread1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("喝酸奶");
            }
        }
    }

    public static void main(String[] args) {
        //静态内部类
        new Thread(new InnerThread1()).start();

        //局部内部类
        class InnerThread2 implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("喝酸奶");
                }
            }
        }
        new Thread(new InnerThread2()).start();

        //匿名内部类 必须借助接口或者父类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("喝酸奶");
                }
            }
        }).start();

        //jdk8使用lambda简化 省略接口名和方法名
        new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    System.out.println("喝酸奶");
                }
            }
        ).start();
		
    }
}
```

## lambda的使用

在推导过程中，考虑到只是简单的推导越简单越好，我使用的是线程相关的Runnable的例子，其中的run()方法并未涉及到返回值和参数。其实在我们实际使用过程中需要参数和返回值，下面我就来介绍如何来使用。
自定义一个接口，其中只包含一个未实现的方法，并且该方法有返回值和参数。下面我定义了一个数学运算的接口。

```java
interface MathOperation {
	int operation(int a, int b);
}
```

为了使用上面数学运算的接口，我们需要定义一个操作的方法。

```java
private int operate(int a, int b, MathOperation mathOperation) {
	return mathOperation.operation(a, b);
}
```

下面列出全部代码。

```java
package com.aiz.se.lambda;

/**
 * @Description 测试Java8 Lambda表达式
 * @Author ZhangYao
 */
public class LambdaTester {

    /**
     * 自定义接口
     */
    interface MathOperation {
        int operation(int a, int b);
    }

    /**
     * @param a
     * @param b
     * @param mathOperation
     * @return a和b经过某种数学运算MathOperation后的结果
     */
    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {
        LambdaTester tester = new LambdaTester();
        //类型声明
        MathOperation add = (int a, int b) -> a + b;
        //不声明类型
        MathOperation sub = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation mul = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号及返回语句
        MathOperation div = (int a, int b) -> a / b;

        //输出结果
        System.out.println("10 + 5 = " + tester.operate(10, 5, add));
        System.out.println("10 - 5 = " + tester.operate(10, 5, sub));
        System.out.println("10 * 5 = " + tester.operate(10, 5, mul));
        System.out.println("10 / 5 = " + tester.operate(10, 5, div));
    }
}
```

> 注：Lambda 表达式只能用于 functional interface ，而 functional interface 只有一个方法。

## 经常使用场景

> 实现Runnable/Comparable<T>/迭代列表/事件监听...

## 参考

> [菜鸟教程](https://www.runoob.com/java/java8-lambda-expressions.html)



# Object类

## 源代码

废话不多说，先怼源码！下面这段代码是`jdk1.8`中的`java.lang.Object`。其他版本的咱也没看，咱也不多扯。

```java
package java.lang;

public class Object {
	private static native void registerNatives();
	static {
		registerNatives();
	}
	public final native Class<?> getClass();
	public native int hashCode();
	public boolean equals(Object obj) {
        return (this == obj);
	}
	protected native Object clone() throws CloneNotSupportedException;
	public String toString() {
		return getClass().getName() + "@" + Integer.toHexString(hashCode());
	}
	public final native void notify();
	public final native void notifyAll();
	public final native void wait(long timeout) throws InterruptedException;
	public final void wait(long timeout, int nanos) throws InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }
        if (nanos < 0 || nanos > 999999) {
            throw new IllegalArgumentException(
                                "nanosecond timeout value out of range");
        }
        if (nanos > 0) {
            timeout++;
        }
        wait(timeout);
	}
	public final void wait() throws InterruptedException {
        wait(0);
	}
	protected void finalize() throws Throwable { }
}
```

学习和了解Java里面的终极父类Object也就是弄清楚上面每个方法也就可以了。

## registerNatives()方法

静态代码块是一个类在初始化过程中必定会执行的内容，所以在类加载时会执行该方法，通过该方法来注册本地方法。

## getClass()方法

getClass方法用来获取对象的编译时类型。任一类型在JVM中的实例只有一个。
如：

```java
Book b1 = new Book(...);
Book b2 = new book();
//
Class<Book> c1 = b1.getClass();
Class<Book> c2 = b2.getClass();
System.out.println(c1 == c2);//true
```

Class是用来表示类型的类型，任何一个类型，被加载进JVM后，它在JVM中类型都是Class。

## hashcode()方法

hashcode方法, 用来生成哈希码值，它是为了将来通过哈希算法存储数据时所需要调用的，目的是计算出具体的位置。默认的实现就是内存地址的码值。如果你想与equals方法保持一致，则也应该重写此方法。

## equals()方法

equals方法,用来判断两个对象是否"相等",它的默认实现就是比地址。同==如果你想从逻辑上去比较两个对象是否相等，则应该重写equals方法。

注：
hashcode和equals方法是“联动”的，它有如下关系：
A. equals返回true的两个对象的哈希码值必需一样
B. equals返回false的两个对象的哈希码值要尽最努力保持不一样。
如：

```java
public class Student {
    private String stuNo;
    private String name;
    private int age;
    //...
}
Student s1 = new Student("1001","ZhangYao",18);
Student s2 = new Student("1001","ZhangYao",18);
System.out.println(s1); //会打印出什么呢？
System.out.println(s1.equals(s2)); // false 如果重写了比较逻辑，则会返回true
System.out.println(s1 == s2); //false
```

## clone()方法

如：

```java
Book b1 = new Book("人类群星闪耀时","茨威格",19.8);
Book b2 = b1;//这不叫克隆[此时b2和b1指向同一个对象]
b2.setPrice(45.6);
//
System.out.printl(b1.getPrice());//45.6

//克隆
public calss UseBook{
	public static void main(String[] args){
		Book b3 = b1.clone();
	}
}
```

注：
Object类的clone方法的实现只完成了 浅拷贝，是指COPY了基本类型的属性以及实现了Cloneable接口的对象类型属性，如：String ,Date,而对于没有实现的Cloneable接口的对象类型属性，则还是会“共用”。

## toString()方法

toString 方法，把对象以字符串的形式表达出来。它的默认实现是把对象的内存地址以16进制方式表达出来。所以，在你的类中应该去重写 toString方法。

##  notify()方法

##  notifyAll()方法

##  wait()方法

## finalize()方法

finalize方法，当一个对象被GC回收之前，JVM会调用这个对象的finalize方法。
虽然这个方法的目的很明确，但是，对象被GC回收的时机确时不确定的。
所以，JVM调用此方法的时机也就是不确定的。
如：

```java
Book b1 = new Book();
//如何让这个对象被“GC”看上呢？
b1 = null;
//此时，按道理，GC会去回收这个对象，但是，时机并不确定。因为GC的执行时机，程序员是不能强制的，它有自己的打算。

//可以尝试去 催促 GC ，比如调用这个方法：
System.gc();
```

# 类和对象、this、static、final关键字

## 前言

先简单聊聊我个人的理解，我理解的面向对象是思想层面的。Oriented Object，简称OO。与面向对象相对于的编程思想是面向过程。
面向过程比较注重的是功能的实现，像C语言那样，以函数为载体，也是基本单位。所有的代码都是由函数来组织的。
面向对象比较注重的是对象的构建，以类为单位，而把功能[方法]封装在类中，以对象为载体，代码都是以类来组织的。
面向对象三大基本特征分别是封装、集成、多态。由面向对象才引申出类和对象的概念。

## 类和对象

### 定义

类是对象的抽象化，它是一个抽象的概念。
对象是类的具体化，它是一个具体的概念。

* 如何知道要定义某个类呢？
  以面向对象的思想去描述客观事物的能力，决定你编写代码的思想。
  所以，OO的步骤为：
   A. 得到一个需求
   B. 根据这个需求去找出所涉及到的所有"对象"
   C. 利用抽象的能力，把找出的这些“对象”进行“归类”[抽象化的过程]
   D. 利用java的语法把它描述成 `xxx.java` 类型，从而得到这个类。

* 如何定义一个类？
  根据对象拥有的属性和能力来定义一个类型，也可以说，一个类由如下部份组成：
    A. 这个类拥有什么？也就是属性。
    B. 这个类能干什么？也就是方法。

### 属性[field]

修饰符 数据类型 属性名[ = 初始值];
从语法上可以看出，属性的定义与变量基本一样，所以，属性也叫实例变量。
如：

```java
public class A {
    //属性
    private int i;
    private String name;
    //
}
```

那么一个类，到底应该定义哪些属性呢？要根据所在对象的上下文来定义。
注：同一个类从不同的视角分析同一个对象，所得到的这个对象属性和功能是不一样的。
如：

```java
public class Student {
    //属性：拥有什么？ 它是数据[数据结构]的载体
    private String stuNo; //学号
    private String stuName; //姓名
    private char gender; //性别
    private String major; //专业
    //...
    //方法：能干什么？ 它是算法的载体
    //学习
    public void study() {
        //...
    }
    //考试
    public void exam() {
        //...
    }
    //...
}
```

`注`：在Java中，只有三种量：
A. 局部变量[Local variable]
B. 实例变量[instance variable]
C. 类变量,也叫静态属性[class variable]
它们的生命周期大大的不同。
局部变量的生命周期只存在于定义它的那一对大括号中。
实例变量随对象而存在。
类变量随类而存在，只要类加载进JVM,则它就在。

### 构造方法[constructor]

构造方法是一个特殊的方法，用于类的初始化。当类中没有定义任何的构造方法时，则JVM会自动提供一个默认构造[空参构造]。它有以下特点：
A. 没有返回类型。
B. 方法名必须与类名同名。
C. 支持重载。

`注`：构造方法的作用：A. 用来给属性赋值的。B. 满足创建对象的语法要求。
`注`：对象创建的过程：
	1).申请堆空间  [对象就创建好了]
	2).给属性赋初始值
	3).调用构造方法[给属性赋值]
如：

```java
	Student s1 = new Student();
	int i;
```

### 对象[object]和引用[references]

对象是存放在堆空间中的"数据"。
引用是指向堆空间中对象的地址。

我们必须通过引用去操作对象，而不能直接操作对象。
没有引用，对象是不会单独存在的。

`注`：一个没有初始化的对象是不能使用的，否则会出现NullPointerException【空指针异常】。

如：

```java
	Student s1 = null;
	s1.study();// 会出现异常
```

`注`：
一个对象可以有多个引用指向它。
一个引用在某一时间最多指向一个对象。

## this关键字

1.表示当前对象[current object]。本质就是"创建好的对象的地址"!
由于在构造方法调用前，对象已经创建。因此，在构造方法中也可以使用this代“当前对象”。
2.用来同类的调用其它的构造方法。

`注`：this不能用于static方法中。

## static关键字

static是Java中表示修饰符的关键字，根据他所修饰的目标不同进行分析。

###  修饰方法

被修饰的方法就是静态方法，它将来是通过ClassName来访问的。如：

```java
public class A {
	//
	public static int add(int a, int b) { 
		return a + b;
	}
	//
	public static void main(String args[]){
		int sum = A.add(1,2);
		System.out.println(sum);//3
	}
}
```

> 静态方法不能被重写。

### 修饰属性

被修饰的属性就是静态属性，也叫 类变量。
类变量的生命周期和类相同，在整个应用程序执行期间都有效。它是属于“类的”，而不是属于“对象的”。

```java
public class B {
	private int i; //实例变量
	private static int j; //类变量,所有此类的实例共享

	//...
	public void setI(int i) { this.i = i;}
	public int getI() { return this.i; }
	//
	public static void setJ(int j1) { j=j1;}
	public static int getJ(){ return j; }
	//
	public static void main(String args[]){
		B b1 = new B();
		b1.setI(100);
		B b2 = new B();
		b2.setI(200);
		b2.setJ(500);

		System.out.println(B.getJ()); //500
		System.out.println(B.getJ()); //500
	}
}
```

* 静态方法不能直接访问非静态成员。
* 非静态方法可以直接访问静态成员。
* 静态方法中不能使用this。
  因为静态成员和非静态成员在初始化的时机上是不一样的。
  有了静态成员后，创建对象的过程如下：
* 在类加载[classload]时：
  * 首先。给静态属性申请空间[永久区]
  * 其次，给静态属性赋初始值。
  * 最后调用静态代码块[如果有的话]

* 在创建类的实例时，总是按如下4步递归地创建父类对象：
  * 为类的非静态属性申请堆空间
  * 给非静态属性赋初始值
  * 调用普通代码块[如果有的话]
  * 调用构造方法

`注`：类加载只会发生1次。

### 修饰代码块

静态代码块只有类加载时被执行1次。
所以，它适合用来执行：
	A. 加载一些大的、固定的资源，如文件
	B. 建立连接池
	...
`注`：静态代码块不能直接访问非静态属性。

### 修饰内部类

被修饰的类称为静态内部类。
如：

```java
public class Outer {
	//属性
	....
	//
	static class Inner {
		//属性

		//方法
		...
	}
	//方法
}
```

## final关键字

final和static都是表示修饰符的关键字，所以我们也根据他所修饰的目标不同进行分析。

### 修饰局部变量，就称为常量。

如：

```java
final int I = 9; //局部常量
```

### 修饰属性，就成了常量属性。

如：

```java
public class A {
	//public final int I = 9; //属性
	public static final int I = 9; //属性
	//...
}
```

`注`：常量属性往往都是再加static修饰。

### 修饰方法，就成了最终方法。

如：

```java
public class A {
	//...
	public final void f() {
		//....
	}	
}
```

`注`：final方法是不能被子类重写的。

### 修饰类，就成了最终类。

如：

```java
public final class B {
	//..
}

public class C extends B { //报错
	//..
}
```

`注`：final类是不能被继承的。

> 问：abstract和final能共同修饰一个类吗？
> 答：不能。

> 问：abstract和private、static能共同修饰一个方法吗？
> 答：不能。



# 面向对象三大特征

OO的核心思想：面向父类、抽象、接口编程；对扩展开放，对修改关闭；高内聚、低耦合。

面向对象三大特征：封装、继承、多态；

五大基本原则：单一职责原则(SRP)、开放封闭原则(OCP)、里氏替换原则(LSP)、依赖倒置原则(DIP)、接口隔离原则(ISP)。

## 封装[encapsulation]

封装简单的说就是该隐藏的隐藏，该公开的公开。优点如下：

* 提高代码的安全性。
* 提高代码的复用性。
* “高内聚”：封装细节，便于修改内部代码，提高可维护性。
* “低耦合”：简化外部调用，便于调用者使用，便于扩展和协作。

### 类的封装

1. 属性尽可能地私有化。但是为了外面的调用者要存取属性，我们必须对属性提供公开的存取方法。也就是get和set方法。如：

```java
public String getStuName(){
	return this.stuName;
}

public void setStuName(String stuName){
	this.stuName = stuName;
}
```

2. 对外的业务方法要公开。

> 涉及到访问修饰符的使用。

### 方法的封装

由于类的数据[属性]和功能[方法]是分开的，所以，我们可以有另一个策略来封装类的功能。

策略一：把类的属性、构造、存取方法以及业务方法全部封装。同一个类中，这种策略适合功能单一、业务简单的场景下。
如：要封装一个银行账户类：

```java
public class Account {
	//属性
	private String no; // 帐号
	private double balance; //余额
	private String realName; //真实姓名
	...
	//构造方法
	...

	//getter/setter方法
	...

	//业务方法
	public void deposit(double money) { ... }

	public void withdraw(double money) { ... }

	public void transfer
		(Account target, double money) { ... }
}
```

策略二：把类的属性、构造、存取方法单独封装成一个实体类，它就是纯数据的载体，而针对这个数据的操作，也就是业务方法另外封装成一个类[业务类]。

```java
//实体类
public class Account {
	//属性
	private String no; // 帐号
	private double balance; //余额
	private String realName; //真实姓名
	...
	//构造方法
	...
	//getter/setter方法
	...
}

//针对Account数据的业务类
public class AccountService {
	//提供操作Account对象的业务方法
	public void deposit
		(Account a, double money) { ... }

	public void withdraw
		(Account a, double money) { ... }

	public void transfer
		(Account from, Account target, double money) { ... }
}
```

> 很显然，策略二的扩展性更好。

## 继承[inheritance]

继承是一种能够让子类快速[获取父类]代码复用的机制。在Java中，类只支持单继承，优点是结构简单，易于管理。

### 继承特点

> A.单继承。
> B.传递性。
> C.所有类都直接或者间接继承于java.lang.Object类。

如果自定义的类型没有显示地指定父类，则自动继承java.lang.Object类。可以使用`extends`关键字表达继承关系。当A类继承B类时，则可以这么表达：

```java
public class B{
	//...
}
public class A extends B{
	//...
}
```

此时，我们可以说：类A是类B的子类/派生类。类B是类A的父类/超类[super class]。

### 何时使用继承呢？

1.使用集成时，两个类之间要满足`IS A`的关系。
2.只有当他们之间满足`IS A`的关系时，才应该使用继承关系否则，不要轻易使用继承。如:

```java
Bird IS A Animal
Apple IS A Fruit
...
```

有了父子类后，类的属性该如何划分？共性归父类、个性归子类。如：

```java
public class Animals {
	//属性
	//...
}

public class Dog extends Animals {
	//属性[个性]
}

public class Cat extends Animals {
	//属性[个性]
}

//父类可以指向一个具体的子类对象
Animals d = new Dog();
Animals c = new Cat();

//编译时类型：
//	就是对象的声明时类型，它可以是父类类型或本身
	如：
	Animals d1 = new Dog();//ok
	Dog d2 =  new Dog();//ok
	Object d3 = new Dog();//ok
//运行时类型
//	就是对象的真正类型，也就是通过getClass()获取的类型。
```

`注`：对象的编译时类型可以变化，但是，它的运行时类型永远不会改变，从对象创建时就已确定。



> 有了父子类后，创建对象的步骤升级为：总是按如下三步递归地创建父类对象
>
> > 1.申请堆空间[本类对象]
> > 2.给属性赋初始值[本类对象]
> > 3.调用构造方法[本类对象]

## 多态[polymorphism]

具有相同类型的对象，调用同一个方法时，表现出不同的行为。但是，这要有如下前提：

> A.要有继承关系
> B.要有方法的重写[被调用的方法]

### 重写

所谓方法的重写[override],是指子类中的方法声明与父类申明保持一致。可以体现在：

> A.子类方法的访问控制修饰符必须大于或等于父类的。
> B.子类方法的返回类型的上限是父类方法的返回类型。
> C.方法名必须一样
> D.参数列表必须一样
> E.子类方法抛出

如：

```java
Animals a1 = new Dog();
Animals a2 = new Cat();

a1.spark();//调用的是Dog()的spark方法
a2.spark();//调用的是Cat()的spark方法
```

1. 对象的编译时类型决定了对象所能“看得见”的行为。
2. 对象的运行时类型决定了对象的真正行为。

为什么此时对象的编译时类型要写Animals呢？
因为要用“统一”的类型来处理这些对象，而使用这些对象的父类类型是一种既可以满足多态的要求又可以达到用户的解决方案。

### OO编程思想

因为要遵守如下OO的思想：

> 面向父类编程
> 面向接口编程
> 面向抽象编程

从编程的角度来理解的话，可以分为：

> 1.对象的编译时类型尽可能的写父类
> 2.方法的参数尽可能地写父类

如：

```java
public void m(Dog d){
	//...
	d.spark();
	//...
}
public void m(Cat c){
	//...
	d.spark();
	//...
}
```

可改成：

```java
public void m(Animals a){
	//...
	d.spark();
	//...
}
```

## super关键字

1. 在构造器中，用来调用父类的构造器。若是构造方法的第一行没有显式的`supper(...)`或者`this(...)`，那么`Java`默认都会调用`super()`，含义是调用父类的无参构造方法。
2. 表示指向父类对象的指针[引用]。如：

```java
public class A {
	protected int index = 50;
	public void f(){
		System.out.println("A:"+index);
	}
	//...
}
public class B extends A {
	private int index = 100;
	//
	public void f(){
		super.f();//调用父类的普通方法
		System.out.println("B:"+index);
		//System.out.println("A:"+super.index);//调用父类的成员属性
	}
```

# 抽象类和接口、拆箱装箱

## 抽象类[abstract class]

抽象类是一种抽象数据类型，它的特点如下：

> A.不能被实例化。
> B.天生就是要被继承的。
> C.可以有构造方法、也可以有非抽象方法，也可以没有抽象方法。

所以，抽象类的定义除了多出一个abstract关键字外，与普通类一样。如：

```java
public abstract class Animals {
	//属性
	....
	//方法
	public void spark(){System.out.println("$%^&##$%#$%");}
}
```

## 抽象方法

就是没有方法体的方法，它直接以;号结束，没有大括号。
它的意思是，对于这个方法的拥有类来说，“它”实现不了，故而做成抽象的。

> A.拥有抽象方法的类必须是抽象类。
> B.但是，抽象类不一定有抽象方法。

如：

```java
public abstract void spark();

public void spark(){....}
```

一个子类继承了一个抽象父类后，则必须实现抽象父类的所以抽象方法。除非这个类也是抽象方法。如：编写一个抽象父类Shape,他拥有计算面积和周长的抽象方法。

```java
public abstract class Shape {
	//属性
	private String name;//

	//抽象方法
	public abstract double area();

	public abstract double girth();
}
//然后定义子类 Triangle 
```

## 接口[interface]

接口它也是一种抽象数据类型，而且是完全抽象的。它的特点：

> A.所有属性都是公开静态常量
> B.所有方法都是公开抽象方法
> C.没有构造
> D.接口支持多重继承

如：

```java
public interface 接口名 [extends  父接口1，父接口2…]{
	//属性：公开静态常量 public static final

	//方法：公开抽象方法 public abstract xxx xxx();
}
```

注：接口编译完成后，也是.class文件。

一个类实现了某个/某些接口，则这个类要实现这些接口的所有抽象方法，除非这个类也是抽象的。

接口的命名：

> 1.以 I 打头。
> 2.以 able 结尾。

如：

```java
public interface IA{
	void ma();//相当于public abstract void ma();
}

public interface IB{
	void mb();
}

public interface IC extends IA,IB{
	void mc();
}

public interface ID{
	int INDEX = 100;//public static final int INDEX = 100;
	void md();
	void me();
}
//
public class IC_Impl implements IC {
	//
	public void mc(){}
	//还要实现IC接口的父接口的方法
	public void ma(){};
	public void mb(){};
}

//
public void ID_Impl implements ID,IB{
	//
	public void md(){}
	public void me(){}
	//
	public void mb(){}
}
```



特殊的两类接口

1.标记接口：既没有方法也没有属性的接口。如:

```java
public interface IHaha{
	//nothing 
}
```

一个类实现这种接口是没有任何“负担”的。如：`java.io.Serializable`

2.常量接口：就是只有属性而没有方法的接口。如：

```java
public interface Season{
	int SPRING = 1;
	int SUMMER = 2;
	int AUTUMU = 3;
	int WINTER = 4;
}
```

但是，这类接口从`JDK5.0`后就很少用了。因为有了枚举。如：

```java
public enum Season{
	SPRING,SUMMER,AUTUMU,WINTER;
}
```

## 拆箱装箱

Java是面向对象的语言，但是我们经常使用的基本数据类型却不是对象。所以实际使用中需要进行类型转换。基本数据类型和对应的包装类型。

| 基本数据类型 | 包装类型  |
| :----------: | :-------: |
|     byte     |   Byte    |
|   boolean    |  Boolean  |
|    short     |   Short   |
|     char     | Character |
|     int      |  Integer  |
|     long     |   Long    |
|    float     |   Float   |
|    double    |  Double   |


```java
Integer a = 123;	//自动装箱Integer a = Integer.valueOf(123);
int b = a;			//自动拆箱int b = a.intValue();

Integer a = null;
int d = c;			//会报空指针
```

## 格式化输出

在java中，也提供了`printf()`方法做格式化输出。比如：

```java
int j = 9;
int j=12;

//想要输出i和j的值：
System.out.println("i = "+i+",j = "+j);

//使用格式化输出
System.out.printf("i = %d  j = %d",i,j);

```

则：占位符该如何定义呢？

> 语法：  %[index$][flag][width][.presision]conversion
>
> > conversion指的是占位符的转换字母，它有：
> > d	代表整数
> > f	代表浮点数
> > s	代表字符或者字符串
> > b	代表布尔值
> > t	代表时间和日期的前半部分
> > ....
> > flag 标记
> > width	占位符宽度
> > .precisoin	只对浮点数有效，表示小数位
> > index$	表示占位符与变量之间的对应关系，默认是一一对应的。



# 结束语

