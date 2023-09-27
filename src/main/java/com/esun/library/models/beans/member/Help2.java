package com.esun.library.models.beans.member;

public class Help2 {
//
//	二、建立 Spring XML 配置文件：
//	在你的 Spring 配置文件（通常是 applicationContext.xml）中，你可以定義 Member 類別的 bean。以下是一個示例配置：
//
//	
//	<!-- 定義 Member 類別的 bean -->
//	<bean id="memberBean" class="com.example.Member">
//	    <property name="memberId" value="12345" />
//	    <property name="memberAccount" value="exampleAccount" />
//	    <property name="memberPassword" value="examplePassword" />
//	</bean>
//	在這個配置中，我們使用 <bean> 元素來定義了一個名為 "memberBean" 的 bean，並設定了 Member 類別的屬性值。
//	
	
	
//	三、在應用程式中使用 Member bean：
//	現在，你可以在應用程式中使用這個配置的 Member bean。你可以通過 Spring 的應用程式上下文來獲取該 bean。
//	import org.springframework.context.ApplicationContext;
//	import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//	public class MainApp {
//	    public static void main(String[] args) {
//	        // 初始化 Spring 上下文
//	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//	        // 獲取 Member bean
//	        Member member = (Member) context.getBean("memberBean");
//
//	        // 使用 Member bean
//	        System.out.println("Member Id: " + member.getMemberId());
//	        System.out.println("Member Account: " + member.getMemberAccount());
//	        System.out.println("Member Password: " + member.getMemberPassword());
//	    }
//	}
	
	
//	不使用繼承jpa的語句，可能會類似這樣
//	@Repository
//	public class MemberDaoImpl implements MemberDao {
//
//	    @Autowired
//	    private EntityManager entityManager;
//
//	    @Override
//	    @Transactional
//	    public String createMember(Member member) {
//	        try {
//	            // 使用 EntityManager 執行資料庫操作，例如將 member 物件儲存到資料庫
//	            entityManager.persist(member);
//	            return "會員創建成功";
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            return "會員創建失敗：" + e.getMessage();
//	        }
//	    }
//	}
	
	
	


//	實作範例
//	那像我這段
//	 @Temporal(TemporalType.TIMESTAMP)
//		@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
//		@Column(name = "member_RegistrationTime", columnDefinition = "datetime")
//	    private Date memberRegistrationTime; // 註冊日期時間
//
//	    @Temporal(TemporalType.TIMESTAMP)
//		@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
//		@Column(name="member_LastLoginTime", columnDefinition = "datetime")
//	    private Date memberLastLoginTime; // 最後登入日期時間
//		
//		
//	    @PrePersist
//		@PreUpdate
//		public void onCreateOrUpdate() {
//		    if (memberRegistrationTime == null) {
//		    	memberRegistrationTime = new Date();
//		    }
//		    if (memberLastLoginTime == null) {
//		    	memberLastLoginTime = new Date();
//		    } else {
//		    	memberLastLoginTime = new Date();
//		    }
//		}
//
//如果你不想使用注釋方式來配置日期欄位和生命週期事件（如 @PrePersist 和 @PreUpdate），你可以使用 Hibernate XML 映射文件來進行這些配置。以下是示範如何將日期欄位和生命週期事件配置為 Hibernate XML 映射文件：

//在 Member.hbm.xml 中配置日期欄位和生命週期事件：
//在 Member.hbm.xml 文件中，你可以使用 <property> 元素來配置日期欄位，並使用 <property> 元素配置生命週期事件。這裡是示範的 XML 映射片段：
//<hibernate-mapping>
//<class name="com.example.Member" table="member">
//    <!-- 其他欄位的配置 -->
//
//    <!-- 註冊日期時間 -->
//    <property name="memberRegistrationTime" column="member_RegistrationTime">
//        <column name="member_RegistrationTime" sql-type="datetime" />
//        <!-- 使用 formula 定義默認值 -->
//        <formula>current_timestamp</formula>
//    </property>
//
//    <!-- 最後登入日期時間 -->
//    <property name="memberLastLoginTime" column="member_LastLoginTime">
//        <column name="member_LastLoginTime" sql-type="datetime" />
//        <!-- 使用 formula 定義默認值 -->
//        <formula>current_timestamp</formula>
//    </property>
//
//    <!-- 生命週期事件 -->
//    <event type="pre-insert">
//        <listener class="com.example.MemberEntityListener" />
//    </event>
//    <event type="pre-update">
//        <listener class="com.example.MemberEntityListener" />
//    </event>
//</class>
//</hibernate-mapping>
//
//在上述配置中，我們使用 <property> 元素定義了 memberRegistrationTime 和 memberLastLoginTime 屬性，同時指定了對應的資料庫欄位和 SQL 類型。我們還使用了 <formula> 元素來定義默認值，這裡使用 current_timestamp 來自動填充當前日期和時間。
//同時，我們使用 <event> 元素配置了生命週期事件，並指定了一個自定義的實體監聽器 MemberEntityListener，你需要自行創建這個實體監聽器以處理生命週期事件。
//
//實作生命週期事件監聽器：
//創建名為 MemberEntityListener 的類別，並實作 PreInsertEventListener 和 PreUpdateEventListener 接口來處理生命週期事件。
//public class MemberEntityListener implements PreInsertEventListener, PreUpdateEventListener {
//    @Override
//    public boolean onPreInsert(PreInsertEvent event) {
//        Object entity = event.getEntity();
//        if (entity instanceof Member) {
//            Member member = (Member) entity;
//            // 在插入之前處理相關邏輯，例如設定日期
//            if (member.getMemberRegistrationTime() == null) {
//                member.setMemberRegistrationTime(new Date());
//            }
//            if (member.getMemberLastLoginTime() == null) {
//                member.setMemberLastLoginTime(new Date());
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public boolean onPreUpdate(PreUpdateEvent event) {
//        Object entity = event.getEntity();
//        if (entity instanceof Member) {
//            Member member = (Member) entity;
//            // 在更新之前處理相關邏輯，例如設定日期
//            member.setMemberLastLoginTime(new Date());
//        }
//        return false;
//    }
//}
//
//
//
//



	public Help2() {
		// TODO Auto-generated constructor stub
	}

}
