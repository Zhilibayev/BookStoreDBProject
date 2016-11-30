import java.sql.Date;

import dao.impl.AuthorDaoJDBC;
import dao.impl.BookDaoJDBC;
import dao.impl.CartDaoJDBC;
import dao.impl.CustomerDaoJDBC;
import dao.impl.PublisherDaoJDBC;
import dao.impl.WrittenByDaoJDBC;
import dao.interfaces.CustomerDao;
import models.Book;
import models.Cart;
import models.Customer;
import models.Publisher;


public class RepresentativeData {
	public static void main(String[] args) {
		
		BookDaoJDBC book = new BookDaoJDBC();
		AuthorDaoJDBC author = new AuthorDaoJDBC();
		PublisherDaoJDBC publisher = new PublisherDaoJDBC();
		try {
			
			
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11111', 'William', 'Shakespeare', 'https://en.wikipedia.org/wiki/William_Shakespeare')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11112', 'Charlotte', 'Bronte', 'https://en.wikipedia.org/wiki/Charlotte_Bront%C3%AB')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11113', 'Charles', 'Dickens', 'https://en.wikipedia.org/wiki/Charles_Dickens')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11116', 'Alexander', 'Pushkin', 'https://en.wikipedia.org/wiki/Alexander_Pushkin')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11117', 'Mikhail', 'Lermontov', 'https://en.wikipedia.org/wiki/Mikhail_Lermontov')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11118', 'Ivan', 'Turgenev', 'https://en.wikipedia.org/wiki/Ivan_Turgenev')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11120', 'Olzhas', 'Suleimenov', 'https://en.wikipedia.org/wiki/Olzhas_Suleimenov')");	
		
		
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1112', '2012-03-17', 21, 3800, 55551, 'A Hero of Our Time', 11117, ' This story opens with one of the novel’s three narrators, an unnamed traveler documenting his journey. This traveler encounters an old army captain, Maxim Maximych, who then becomes the next narrator. Maxim tells the traveler a story of Grigory Pechorin, a fellow soldier and the novel’s third narrator. Maxim’s story paints Pechorin as manipulative due to his ability to charm. Pechorin meets a beautiful young woman, Bela, who becomes the object of his fixation. Pechorin is made aware of Bela’s brother’s, Azamat’s, fixation on the horse of a fellow wedding guest. ' )");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, description, author_aid) values ('abc1113', '2010-08-03', 28, 3500, 55552, 'Eugene Onegin', 'In the 1820s, Eugene Onegin is a bored Saint Petersburg dandy, whose life consists of balls, concerts, parties and nothing more. One day he inherits a landed estate from his uncle. When he moves to the country, he strikes up a friendship with his neighbor, a starry-eyed young poet named Vladimir Lensky.', 11116)");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, description, author_aid) values ('abc1115', '2009-12-04', 22, 3700, 55551, 'Fathers and Sons', 'Arkady Kirsanov has just graduated from the University of Petersburg and returns with a friend, Bazarov, to his fathers modest estate in an outlying province of Russia. His father, Nikolai, gladly receives the two young men at his estate, called Maryino, but Nikolais brother, Pavel, soon becomes upset by the strange new philosophy called nihilism which the young men, especially Bazarov advocate.', 11118)");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, description, author_aid) values ('abc1116', '2011-06-17', 28, 3800, 55553, 'Hamlet', ' Hamlet is a tragedy written by William Shakespeare at an uncertain date between 1599 and 1602. Set in the Kingdom of Denmark, the play dramatises the revenge Prince Hamlet is called to wreak upon his uncle, Claudius, by the ghost of Hamlets father, King Hamlet.', 11111)");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, description, author_aid) values ('abc1117', '2013-11-11', 32, 3200, 55554, 'Jane Eyre', 'The novels setting is somewhere in the north of England, during the reign of George III (1760–1820), and goes through five distinct stages: Janes childhood at Gateshead Hall, where she is emotionally and physically abused by her aunt and cousins; her education at Lowood School, where she gains friends and role models but suffers privations and oppression; her time as governess at Thornfield Hall, where she falls in love with her Byronic employer, Edward Rochester', 11112)");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, description, author_aid) values ('abc1118', '2012-10-19', 32, 3800, 55551, 'Oliver Twist', 'In this early example of the social novel, Dickens satirizes the hypocrisies of his time, including child labour, the recruitment of children as criminals, and the presence of street children. The novel may have been inspired by the story of Robert Blincoe, an orphan whose account of working as a child labourer in a cotton mill was widely read in the 1830s.', 11113)");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, description, author_aid) values ('abc1119', '2014-07-14', 32, 2200, 55555, 'Az i ia', 'Suleimenov was born on 18 May 1936 in Alma-Ata. He graduated from Geological Sciences Department of Kazakh State University in 1959. Suleimenov also finished Gorkii Institute of Literature in 1961. Between 1962-1971, he worked at Kazakhskaya Pravda.', 11120)");
	
		
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11121', 'Antoine', 'de Saint-Exupéry', 'https://en.wikipedia.org/wiki/Antoine_de_Saint-Exup%C3%A9ry')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11122', 'Alexandre', 'Dumas', 'https://en.wikipedia.org/wiki/Alexandre_Dumas')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11123', 'Victor', 'Hugo', 'https://en.wikipedia.org/wiki/Victor_Hugo')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11124', 'Charles', 'Perrault', 'https://en.wikipedia.org/wiki/Charles_Perrault')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11125', 'Mark', 'Twain', 'https://en.wikipedia.org/wiki/Mark_Twain')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11126', 'Ernest', 'Hemingway', 'https://en.wikipedia.org/wiki/Ernest_Hemingway')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11127', 'Aleksandr', 'Solzhenitsyn', 'https://en.wikipedia.org/wiki/Aleksandr_Solzhenitsyn')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11128', 'Akhmet', 'Baitursynov', 'https://en.wikipedia.org/wiki/Akhmet_Baitursynov')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11129', 'Khaled', 'Hosseini', 'https://en.wikipedia.org/wiki/Khaled_Hosseini')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11130', 'Jack', 'London', 'https://en.wikipedia.org/wiki/Jack_London')");	
	
			
			
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, description, author_aid) values ('abc1111', '2014-07-14', 32, 2200, 55556, 'The Little Prince', 'The narrator explains that, as a young boy, he once drew a picture of a boa constrictor digesting an elephant in its stomach; however, every adult who saw the picture would mistakenly interpret it as a drawing of a hat. Whenever the narrator would try to correct this confusion, he was ultimately advised to set aside drawing and take up a more practical or mature hobby.', 11121)");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1122', '2008-02-18', 24, 3800, 55551, 'The Three Musketeers', '11122', 'In 1625 France, dArtagnan (a poor young nobleman) leaves his family in Gascony and travels to Paris to join the Musketeers of the Guard. At an inn in Meung-sur-Loire, an older man derides dArtagnans horse. Insulted, dArtagnan demands a duel. The older mans companions beat dArtagnan unconscious with a cooking pot and a metal tong that breaks his sword. His letter of introduction to Monsieur de Tréville, the commander of the Musketeers, is also stolen.')");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1123', '2009-03-11', 29, 2900, 55556, 'Les Misérables', '11123', 'The story begins in 1815 in Digne, as the peasant Jean Valjean, just released from 19 years imprisonment in the galleys—five for stealing bread for his starving sister and her family and fourteen more for numerous escape attempts—is turned away by innkeepers because his yellow passport marks him as a former convict.')");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1124', '2011-04-23', 25, 2800, 55554, 'Stories or Fairy Tales from Past Times with Morals', '11124', 'Stories or Fairy Tales from Past Times with Morals is a collection of literary fairy tales written by Charles Perrault, published in Paris in 1697. The work became popular because it was written at a time when fairy tales were fashionable amongst aristocrats in Parisian literary salons.')");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1125', '2010-05-11', 15, 3200, 55553, 'The Old Man and the Sea', '11126', 'It was the last major work of fiction by Hemingway that was published during his lifetime. One of his most famous works, it tells the story of Santiago, an aging Cuban fisherman who struggles with a giant marlin far out in the Gulf Stream off the coast of Florida.')");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1126', '2012-05-13', 45, 3300, 55551, 'The Gulag Archipelago', '11127', 'It is a book by Aleksandr Solzhenitsyn about the Soviet forced labor camp system. The three-volume book is a narrative relying on eyewitness testimony and primary research material, as well as the authors own experiences as a prisoner in a gulag labor camp.')");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1127', '2014-08-19', 40, 3600, 55553, 'White Fang', '11130', 'The story begins before the three-quarters wolf-dog hybrid is born, with two men and their sled dog team on a journey to deliver a coffin to a remote town named Fort McGurry in the higher area of the Yukon Territory, Canada. The men, Bill and Henry, are stalked by a large pack of starving wolves over the course of several days.')");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1128', '2011-07-03', 24, 3500, 55556, 'The Kite Runner', '11129', 'Amir, a well-to-do Pashtun boy, and Hassan, a Hazara who is the son of Ali, Amirs fathers servant, spend their days kite fighting in the hitherto peaceful city of Kabul. Hassan is a successful kite runner for Amir; he knows where the kite will land without watching it.')");

		
		
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55555', 'Atamura', 'KZ Almaty, Abylai Khan av. 75/72', '87272791185', 'atamura.kz')");
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55551', 'Rosman Publishing', 'RU Moscow, Oktyabrskaya Street 4/7', '+74959337130', 'http://rosman.ru/')");
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55552', 'Izdatelstvo VES MIR', 'RU Moscow Kolpachnyi pereulok', '+74956236839', 'http://www.vesmirbooks.ru/')");
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55553', 'The National Academies Press', 'US Washingtone DC Fifth Street NW500', '+12023343117', 'https://www.nap.edu/')");
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55554', 'Thomson Reuters', 'US Interfirst Drive Ann Arbor, Michigan 48108', '+18009688900', 'http://thomsonreuters.com/en.html')");
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55556', 'Hachette Livre', 'FR Paris RUE JEAN BLEUZEN 58', '+330155001100', 'http://www.hachette.com/')");

			
			
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55557','Pearson', 'UK London Baker Street 1', '9900-9978-87-87',	'https://www.pearson.com/');");
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55558','Ox 9aford University Press', 'UK London Breastle Beach 23','9900-9978-87-87', 'http://global.oup.com/?cc=kz');");
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55559','DoubleZhPress', 'KZ Astana Kabanbay Batyr 53' ,'9900-9978-87-87','Opps');");
//		publisher.savePublisherByQuery("insert into dzhstore.publisher(pid, name, address, phone, url) values ('55560','Penguin Random House', 'Germany Dhuseldorf Zwign 34','9900-9978-87-87', 'http://www.penguinrandomhouse.com/');");			

			
			
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1131', '2014-07-23', 28, 2700, 55557, 'Pride and Prejudice', '11136', 'The narrative opens with news in the Bennet family that Mr Bingley, a wealthy, charismatic and sociable young bachelor, is moving into Netherfield Park in the neighbourhood. Mr Bingley is soon well received while his friend Mr Darcy makes a less favourable impression by appearing proud and condescending at a ball that they attend (he does not dance or join in the light conversation).')");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1132', '2012-04-21', 31, 3100, 55555, 'Abai Zholy', '11135', 'The first 20 years of life of M.Auezov resemble the childhood, adolescence and youth of his favorite poet and spiritual guide – Abai. Subsequently, in a famous epic, he described the same steppe, the same village, and the same social environment as experienced by Abai.')");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1133', '2011-09-10', 25, 3000, 55559, 'Crime and Punishment', '11133', 'Raskolnikov, a conflicted former student, lives in a tiny, rented room in Saint Petersburg. He refuses all help, even from his friend Razumikhin, and devises a plan to murder and rob an elderly pawn-broker and money-lender, Alyona Ivanovna. His motivation comes from the overwhelming sense that he is predetermined to kill the old woman by some power outside of himself.')");
//		book.saveBookByQuery("insert into book(isbn, year, quantity, price, publisher_pid, title, author_aid, description) values ('abc1134', '2011-02-20', 21, 2900, 55560, 'Anna Karenina', '11134', 'Anna Karenina is the tragic story of a married aristocrat/socialite and her affair with the affluent Count Vronsky. The story starts when she arrives in the midst of a family broken up by her brothers unbridled womanizing—something that prefigures her own later situation, though she would experience less tolerance by others.')");

			
			
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11133', 'Fyodor', 'Dostoyevsky', 'https://en.wikipedia.org/wiki/Fyodor_Dostoyevsky')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11134', 'Leo', 'Tolstoy', 'https://en.wikipedia.org/wiki/Leo_Tolstoy')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11135', 'Mukhtar', 'Auezov', 'https://en.wikipedia.org/wiki/Mukhtar_Auezov')");	
//		author.saveAuthorByQuery("insert into dzhstore.author(aid, fname, lname, url) values ('11136', 'Jane', 'Austen', 'https://en.wikipedia.org/wiki/Jane_Austen')");
		
		}catch(Exception e){
			e.printStackTrace();
		}


		
	}

}