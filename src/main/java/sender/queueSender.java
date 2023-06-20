package sender;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;

import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;


import org.apache.log4j.BasicConfigurator;

import helper.XMLconvert;
import ms.entity.Person;

public class queueSender {
	public static void main(String[] args) throws Exception {
		BasicConfigurator.configure();
		Properties setting=new Properties();
		setting.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
				"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		setting.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
		 Context ctx=new InitialContext(setting);
		 ConnectionFactory factory= (ConnectionFactory) ctx.lookup("ConnectionFactory");
		 Destination destination=(Destination) ctx.lookup("dynamicQueues/thanthidet");
		 Connection con=factory.createConnection("admin","admin");
		//connect to MOM
		con.start();
		//create session
		Session session=con.createSession(
		/*transaction*/false,
		/*ACK*/Session.AUTO_ACKNOWLEDGE
		);
		//create producer
		MessageProducer producer = session.createProducer(destination);
		//create text message
		Message msg=session.createTextMessage("hello mesage from ActiveMQ");
		producer.send(msg);
		Person p=new Person(1001, "Thân Thị Đẹt", Date.valueOf(LocalDate.of(2022,10, 10)));
		String xml=new XMLconvert<Person>(p).object2XML(p);
		msg=session.createTextMessage(xml);
		producer.send(msg);
		//shutdown connection
		session.close();con.close();
		System.out.println("Finished..."); 
				 
		 
	}
}
