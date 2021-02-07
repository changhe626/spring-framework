package com.onyx.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component

//true使用cglib代理,flase默认使用jdk的代理.
@EnableAspectJAutoProxy(proxyTargetClass = true)

@Aspect  //定义切面
public class UserAspect {

	/**
	 * 申明切入点，匹配UserServiceImpl2所有方法调用
	 * execution匹配方法执行连接点
	 * within:将匹配限制为特定类型中的连接点
	 * * args：参数
	 * * target：目标对象
	 * * this：代理对象
	 * */
	@Pointcut("execution(* com.onyx.service.UserServiceImpl2.*(..))")
	public void pintCut(){
	}

	/**
	 * 具体的通知.
	 */
	@Before("pintCut()")
	public void beforePintCut(){
		System.out.println("before pointcut");
	}


	/**
	 * aspect:一定要给spring去管理  抽象  aspectj->类
	 * pointcut:切点表示连接点的集合  ------------------->           表  （
	 *    我的理解：PointCut是JoinPoint的谓语，这是一个动作，主要是告诉通知连接点在哪里，
	 *    切点表达式决定 JoinPoint 的数量）
	 * Joinpoint:连接点   目标对象中的方法 ---------------->    记录
	 *   （我的理解：JoinPoint是要关注和增强的方法，也就是我们要作用的点）
	 * Weaving :把代理逻辑加入到目标对象上的过程叫做织入
	 * target 目标对象 原始对象
	 * aop Proxy 代理对象  包含了原始对象的代码和增加后的代码的那个对象
	 * advice:通知    (位置 + logic)
	 *
	 * aop是一种思想,spring aop是一种实现.AspectJ也是一种实现.
	 *
	 * 代理
	 * 继承 聚合接口 动态代理
	 * 因为java是单继承,所以是基于接口实现的.
	 * extens Proxy implements  XXXService
	 *
	 */


/**
 advice通知类型:
 Before 连接点执行之前，但是无法阻止连接点的正常执行，除非该段执行抛出异常
 After  连接点正常执行之后，执行过程中正常执行返回退出，非异常退出
 After throwing  执行抛出异常的时候After (finally)  无论连接点是正常退出还是异常退出，都会执行
 Around advice: 围绕连接点执行，例如方法调用。这是最有用的切面方式。
   around通知可以在方法调用之前和之后执行自定义行为。
   它还负责选择是继续加入点还是通过返回自己的返回值或抛出异常来快速建议的方法执行。

 Proceedingjoinpoint 和JoinPoint的区别:
 Proceedingjoinpoint 继承了JoinPoint,
 proceed()这个是aop代理链执行的方法。并扩充实现了proceed()方法，
 用于继续执行连接点。JoinPoint仅能获取相关参数，无法执行连接点。
 JoinPoint的方法
 1.java.lang.Object[] getArgs()：获取连接点方法运行时的入参列表； 
 2.Signature getSignature() ：获取连接点的方法签名对象； 
 3.java.lang.Object getTarget() ：获取连接点所在的目标对象； 
 4.java.lang.Object getThis() ：获取代理对象本身；proceed()有重载,
   有个带参数的方法,可以修改目标方法的的参数

 */

}
