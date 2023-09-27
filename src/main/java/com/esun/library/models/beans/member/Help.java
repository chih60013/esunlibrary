package com.esun.library.models.beans.member;

public class Help {

	public Help() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * annotation（註釋）資料夾：
	 * 
	 * 這個資料夾可能用於存放自定義的註釋類別（Annotations）或與註釋相關的代碼。
	 * 在Java中，註釋是一種用於提供元數據（metadata）的機制，它們通常用於描述類別、方法、字段等元素的額外信息。註釋可以用於各種用途，
	 * 包括配置Spring bean、定義Hibernate映射、實現AOP切面等。
	 * 在這個資料夾中，你可能會存放自己定義的註釋類別，或者與註釋處理器（Annotation Processors）相關的程式碼。
	 * aop（面向切面編程）資料夾：
	 * 
	 * 這個資料夾可能用於存放與面向切面編程（AOP）相關的代碼。
	 * AOP是一種編程範式，它允許你將應用程式的關注點（concerns）模塊化，例如日誌記錄、安全性檢查、事務管理等，並將它們獨立於主要業務邏輯。通過AOP，
	 * 你可以在應用程式的不同位置（稱為切點）定義這些關注點，然後將它們應用於適當的地方。
	 * 在這個資料夾中，你可能會存放與AOP相關的切面類別、通知（advice）以及配置文件，以實現AOP功能。
	 * 
	 * constant（常數）資料夾：
	 * 
	 * 這個資料夾可能用於存放應用程式中使用的常數值或常數類別。
	 * 常數通常是在應用程式中多次使用的固定值，例如錯誤代碼、設定參數、枚舉類別等。將這些常數集中存放在一個資料夾中有助於代碼的管理和維護。
	 * controller（控制器）資料夾：
	 * 
	 * 這個資料夾可能用於存放控制器類別，特別是在MVC（模型-視圖-控制器）設計模式中，控制器用於處理HTTP請求和協調應用程式的行為。
	 * 控制器通常處理用戶輸入，調用服務層或業務邏輯，然後將結果返回給客戶端。 dataaccessor（資料存取器）資料夾：
	 * 
	 * 這個資料夾可能用於存放與資料庫或其他資料存取相關的程式碼。 資料存取器通常包括與資料庫連接、查詢執行、數據檢索和存儲相關的邏輯。
	 * exception（異常）資料夾：
	 * 
	 * 這個資料夾可能用於存放自定義異常類別。 自定義異常通常用於處理應用程式中的特定錯誤情況，並提供更具信息性的錯誤消息。 handler（處理器）資料夾：
	 * 
	 * 這個資料夾可能用於存放諸如HTTP請求處理器、事件處理器等不同類型的處理器類別。 處理器通常處理特定類型的請求或事件。 service（服務）資料夾：
	 * 
	 * 這個資料夾可能用於存放服務類別，這些類別實現應用程式的業務邏輯。 服務類別通常包括應用程式的主要邏輯，如用戶帳號管理、交易處理等。
	 * utils（工具）資料夾：
	 * 
	 * 這個資料夾可能用於存放各種工具類別或實用程式函數，它們可能被整個應用程式的多個部分重複使用。
	 * 工具類別通常包括各種實用程式功能，如日期處理、字符串操作、文件處理等。
	 * 這些資料夾可以根據你的專案需求和組織結構進一步定義和使用。它們有助於將代碼模塊化，使代碼更具可讀性和維護性，並幫助團隊協作。
	 * 
	 * 
	 * 
	 * 下面這個是 一般範例 import java.sql.Connection; import java.sql.PreparedStatement;
	 * import java.sql.ResultSet; import java.sql.SQLException;
	 * 
	 * public class DataAccessor { private Connection connection;
	 * 
	 * public DataAccessor(Connection connection) { this.connection = connection; }
	 * 
	 * // 執行SQL查詢，並返回結果集 public ResultSet executeQuery(String sql) throws
	 * SQLException { PreparedStatement preparedStatement =
	 * connection.prepareStatement(sql); return preparedStatement.executeQuery(); }
	 * 
	 * // 執行SQL更新操作，如INSERT、UPDATE、DELETE public int executeUpdate(String sql)
	 * throws SQLException { PreparedStatement preparedStatement =
	 * connection.prepareStatement(sql); return preparedStatement.executeUpdate(); }
	 * 
	 * // 關閉資源，釋放連接 public void close() throws SQLException { if (connection !=
	 * null) { connection.close(); } } }
	 * 
	 * 
	 * 
	 * 
	 * 原本 bean 裡面是這樣寫
	 * 
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name="member_Id") private Integer memberId;
	 * 
	 * 如果換去 xml 可能會寫成這樣
	 * 
	 * <?xml version="1.0" encoding="UTF-8"?> <!DOCTYPE hibernate-mapping PUBLIC
	 * "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
	 * "http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
	 * 
	 * <hibernate-mapping> <class name="com.example.Member" table="member">
	 * <idname="memberId" column="member_Id"> <generator class="identity" /> </id>
	 * <property name="memberPhoneNumber" column="member_PhoneNumber"not-null="true"
	 * unique="true" /> </class> </hibernate-mapping>
	 *
	 *9/27 
	 *示範   最下面的沒什麼用處
	 * public class MainApp { public static void main(String[] args) { // 初始化 Spring
	 * 上下文 ApplicationContext context = new
	 * ClassPathXmlApplicationContext("applicationContext.xml");
	 * 
	 * // 獲取 Member bean Member member = (Member) context.getBean("memberBean");
	 * 
	 * // 使用 Member bean System.out.println("Member Id: " + member.getMemberId());
	 * System.out.println("Member Account: " + member.getMemberAccount());
	 * System.out.println("Member Password: " + member.getMemberPassword()); } }
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */

}
