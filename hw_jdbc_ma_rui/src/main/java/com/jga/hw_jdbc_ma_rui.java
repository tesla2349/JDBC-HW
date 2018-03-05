package com.jga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jga.dao.AddressDao;
import com.jga.dao.DeveloperDao;
import com.jga.dao.PageDao;
import com.jga.dao.PhoneDao;
import com.jga.dao.PriviledgeDao;
import com.jga.dao.RoleDao;
import com.jga.dao.WebsiteDao;
import com.jga.dao.WidgetDao;
import com.jga.models.Developer;
import com.jga.models.Page;
import com.jga.models.Role;
import com.jga.models.Website;
import com.jga.models.Widget;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class hw_jdbc_ma_rui {
	 public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	public static void main(String[] args) {
		SpringApplication.run(hw_jdbc_ma_rui.class, args);
		
		/*
		 * Create Developers and Users
		 */
		
		DeveloperDao dao = DeveloperDao.getInstance();
		
		Developer d1 = new Developer(1,"4321rewq","Alice","Wonder","alice","alice","alice@wonder.com",null);
		dao.createDeveloper(d1);
		Developer d2 = new Developer(2,"5432trew","Bob","Marley","bob","bob","bob@marley.com",null);
		dao.createDeveloper(d2);
		Developer d3 = new Developer(3,"6543ytre","Charles","Garcia","charlie","charlie","chuch@garcia.com",null);
		dao.createDeveloper(d3);
		Developer d4 = new Developer(4,"7654fda","Dan","Martin","dan","dan","dan@martin.com",null);
		dao.createDeveloper(d4);
		Developer d5 = new Developer(5,"5678dfgh","Ed","Karaz","ed","ed","ed@kar.com",null);
		dao.createDeveloper(d5);
		
		/*
		 * Create Websites for Developers
		 */
		
		WebsiteDao wdao = WebsiteDao.getInstance();
		
		Website w1= new Website(1,"Facebook","an online social media and social networking service",parseDate("2018-03-04"),parseDate("2018-03-04"),1234234,1);
		wdao.createWebsiteForDeveloper(1, w1);
		d1.addWebsite(w1);
		Website w2= new Website(2,"Twitter","an online news and social networking service",parseDate("2018-03-04"),parseDate("2018-03-04"),4321543,2);
		wdao.createWebsiteForDeveloper(2, w2);
		d2.addWebsite(w2);
		Website w3= new Website(3,"Wikipedia","a free online encyclopedia",parseDate("2018-03-04"),parseDate("2018-03-04"),3456654,3);
		wdao.createWebsiteForDeveloper(3, w3);
		d3.addWebsite(w3);
		Website w4= new Website(4,"CNN","an American basic cable and satellite television news channel",parseDate("2018-03-04"),parseDate("2018-03-04"),6543345,1);
		wdao.createWebsiteForDeveloper(1, w4);
		d1.addWebsite(w4);
		Website w5= new Website(5,"CNET","an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",parseDate("2018-03-04"),parseDate("2018-03-04"),5433455,2);
		wdao.createWebsiteForDeveloper(2, w5);
		d2.addWebsite(w5);
		Website w6= new Website(6,"Gizmodo","a design, technology, science and science fiction website that also writes articles on politics",parseDate("2018-03-04"),parseDate("2018-03-04"),4322345,3);
		wdao.createWebsiteForDeveloper(3, w6);
		d3.addWebsite(w6);
		
		/*
		 * Assign Roles to Websites
		 */
		RoleDao rdao = RoleDao.getInstance();
	
		rdao.assignWebsiteRole(1, 1, "owner");
		rdao.assignWebsiteRole(1, 2, "admin");
		rdao.assignWebsiteRole(1, 3, "editor");
		rdao.assignWebsiteRole(1, 4, "owner");
		rdao.assignWebsiteRole(1, 5, "admin");
		rdao.assignWebsiteRole(1, 6, "editor");
		rdao.assignWebsiteRole(2, 1, "editor");
		rdao.assignWebsiteRole(2, 2, "owner");
		rdao.assignWebsiteRole(2, 3, "admin");
		rdao.assignWebsiteRole(2, 4, "editor");
		rdao.assignWebsiteRole(2, 5, "owner");
		rdao.assignWebsiteRole(2, 6, "admin");
		rdao.assignWebsiteRole(3, 1, "admin");
		rdao.assignWebsiteRole(3, 2, "editor");
		rdao.assignWebsiteRole(3, 3, "owner");
		rdao.assignWebsiteRole(3, 4, "admin");
		rdao.assignWebsiteRole(3, 5, "editor");
		rdao.assignWebsiteRole(3, 6, "owner");
		
		/*
		 * Create Pages for Websites
		 */
		PageDao pdao = PageDao.getInstance();
		Page p1 = new Page(1,"Home","Landing page",parseDate("2018-01-08"),parseDate("2018-03-04"),123434,5);
		pdao.createPageForWebsite(5, p1);
		w5.addPage(p1);
		Page p2 = new Page(2,"About","Website description",parseDate("2018-01-08"),parseDate("2018-03-04"),234545,6);
		pdao.createPageForWebsite(6, p2);
		w6.addPage(p2);
		Page p3 = new Page(3,"Contact","Addresses, phones, and contact info",parseDate("2018-01-08"),parseDate("2018-03-04"),345656,3);
		pdao.createPageForWebsite(3, p3);
		w3.addPage(p3);
		Page p4 = new Page(4,"Preferences","Where users can configure their preferences",parseDate("2018-01-08"),parseDate("2018-03-04"),456776,4);
		pdao.createPageForWebsite(4, p4);
		w4.addPage(p4);
		Page p5 = new Page(5,"Profile","Users can configure their personal information",parseDate("2018-01-08"),parseDate("2018-03-04"),567878,5);
		pdao.createPageForWebsite(5, p5);
		w5.addPage(p5);
		
		/*
		 * Assign Roles to Pages
		 */
		rdao.assignPageRole(1, 1, "editor");
		rdao.assignPageRole(1, 2, "writer");
		rdao.assignPageRole(1, 3, "reviewer");
		rdao.assignPageRole(1, 4, "editor");
		rdao.assignPageRole(1, 5, "writer");
		rdao.assignPageRole(2, 1, "reviewer");
		rdao.assignPageRole(2, 2, "editor");
		rdao.assignPageRole(2, 3, "writer");
		rdao.assignPageRole(2, 4, "reviewer");
		rdao.assignPageRole(2, 5, "editor");
		rdao.assignPageRole(3, 1, "writer");
		rdao.assignPageRole(3, 2, "reviewer");
		rdao.assignPageRole(3, 3, "editor");
		rdao.assignPageRole(3, 4, "writer");
		rdao.assignPageRole(3, 5, "reviewer");
		
		/*
		 * Create Widgets for Pages
		 */
		WidgetDao widao = WidgetDao.getInstance();
		Widget wi1 = new Widget(1, "head123", "heading", "Welcome", 0, (Integer)null, (Integer)null, null, 1);
		widao.createWidgetForPage(1, wi1);
		p1.addWidget(wi1);
		
		Widget wi2 = new Widget(2, "post234", "html", "<p>Lorem</p>", 0, (Integer)null, (Integer)null, null, 2);
		widao.createWidgetForPage(2, wi2);
		p2.addWidget(wi2);
		
		Widget wi3 = new Widget(3, "head345", "heading", "Hi", 1, (Integer)null, (Integer)null, null, 3);
		widao.createWidgetForPage(3, wi3);
		p3.addWidget(wi3);
		
		Widget wi4 = new Widget(4, "intro456", "html", "<h1>Hi</h1>", 2, (Integer)null, (Integer)null, null, 3);
		widao.createWidgetForPage(3, wi4);
		p3.addWidget(wi4);
		
		Widget wi5 = new Widget(5, "image345", "image", null, 3, 50, 100, "/img/567.png", 3);
		widao.createWidgetForPage(3, wi5);
		p3.addWidget(wi5);
		
		Widget wi6 = new Widget(6, "video456", "youtube", null, 0, 400, 300, "https://youtu.be/h67VX51QXiQ", 4);
		widao.createWidgetForPage(4, wi6);
		p4.addWidget(wi6);
		
		/*
		 * Update Primary Address for Developer
		 */
		PhoneDao phdao = PhoneDao.getInstance();
		phdao.updatePrimaryPhoneForDeveloper(3,"333-444-5555");
		
		
		/*
		 * Update Widget
		 */
		widao.updateWidget(3, wi3);
		
		/*
		 * Update Page
		 */
		List<Page> pages = pdao.findPagesForWebsite(5);
		for(Page page:pages) {
			int id = page.getId();
			String title = page.getTitle();
			title = "CNET-"+title;
			page.setTitle(title);
			pdao.updatePage(id, page);
		}
		
		/*
		 * Update Roles
		 */
		Role role1 = rdao.retrievePageRole(3, 1);
		String dtype1 = role1.getDtype();
		Role role2 = rdao.retrievePageRole(2, 1);
		String dtype2 = role2.getDtype();
		rdao.assignPageRole(2, 1, dtype1);
		rdao.assignPageRole(3, 1, dtype2);
		
		/*
		 * Delete Primary Address for Developer
		 */
		AddressDao adao = AddressDao.getInstance();
		adao.deletePrimaryAddressForDeveloper(1);
		
		/*
		 * Delete Widget
		 */
		List<Widget> widgets = widao.findWidgetsForPage(3);
		List<Integer> ids = new ArrayList<>();
		List<Integer> orders = new ArrayList<>();
		for(Widget widget:widgets) {
			int id = widget.getId();
			int order = widget.getOrder();
			ids.add(id);
			orders.add(order);
		}
		int max_order = Collections.max(orders);
		int max_index = orders.indexOf(max_order);
		int id_delete = ids.get(max_index);
		widao.deleteWidget(id_delete);
		
		/*
		 * Delete Page
		 */
		pages = pdao.findPagesForWebsite(3);
		for(Page page:pages) {
			int id = page.getId();
			pdao.deletePage(id);
		}
		
		/*
		 * Delete Website
		 */
		wdao.deleteWebsite(5);
		rdao.deleteWebsiteRoles(5);
		PriviledgeDao prdao = PriviledgeDao.getInstance();
		prdao.deleteWebsitePriviledges(5);
		
		pages = pdao.findPagesForWebsite(5);
		for(Page page:pages) {
			int id = page.getId();
			rdao.deletePageRoles(id);
			prdao.deletePagePriviledges(id);
		}
	}
}







