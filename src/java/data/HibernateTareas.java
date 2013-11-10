package data;

import java.util.Collection;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import domain.tareas.Tarea;
import domain.periodicidad.PeriodicidadSemanal;
import domain.sesiones.Sesion;
import org.hibernate.Transaction;


public class HibernateTareas extends HibernateDaoSupport implements PersistenciaTareas {

	public void almacenarTareas(Collection<Tarea> tareas) {
		for (Tarea t : tareas) almacenarTarea(t);
	}
	
	public void almacenarTarea(Tarea t) {
            if (t == null) return;

            almacenarPeriodicidadSemanal(t.getPeriodicidadSemanal());
            almacenarSesiones(t.getSesiones());

            logger.info(t.getId());

            getHibernateTemplate().saveOrUpdate(t);

            logger.info(t.getId());          
            logger.info(t.getTarea() + " almacenada en la base de datos.");
        }

	public void almacenarSesion(Sesion s) {
		if (s == null) return;
		getHibernateTemplate().saveOrUpdate(s);
	}
	
	public void almacenarSesiones(Collection<Sesion> sesiones) {
		for (Sesion s : sesiones) almacenarSesion(s);
	}
	
	public void almacenarPeriodicidadSemanal(PeriodicidadSemanal p) {
		if (p == null) return;
		getHibernateTemplate().saveOrUpdate(p);
	}
	
	public Collection<Tarea> cargarTareas() {
		return (Collection<Tarea>)getHibernateTemplate().find("from Tarea where realizada=0");
	}
	
	public Collection<Sesion> cargarSesiones() {
		return (Collection<Sesion>)getHibernateTemplate().find("from Sesion");
	}
	
	public Collection<PeriodicidadSemanal> cargarPeriodicidadSemanal() {
		return (Collection<PeriodicidadSemanal>)getHibernateTemplate().find("from PeriodicidadSemanal");
	}

	public void actualizarTarea(Tarea tarea) {
		getHibernateTemplate().update(tarea);
	}

	public void actualizarTareas(List<Tarea> tareas) {
		for (Tarea tarea : tareas) actualizarTarea(tarea);
	}
}
