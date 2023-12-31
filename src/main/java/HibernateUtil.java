import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

public class HibernateUtil {
    private static SessionFactory factory;
    private static final Logger LOG = Logger.getLogger(HibernateUtil.class.getName());

    public HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    static {
        try {
            factory = (new Configuration()).configure("hibernate_configuration.cfg.xml").buildSessionFactory();
        } catch (HibernateException var1) {
            LOG.error(var1);
        }

    }
}
