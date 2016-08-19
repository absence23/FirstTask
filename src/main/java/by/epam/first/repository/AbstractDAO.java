package by.epam.first.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.epam.first.entity.Entity;
import by.epam.first.exception.DAOException;

/**
 * Created by User on 18.08.2016.
 */
public abstract class AbstractDAO<K, T extends Entity> {
	    
	private static Logger logger = LoggerFactory.getLogger(AbstractDAO.class);
	    
	/**
     * Extract all entities of class T from db
     *
     * @return List of entities
     * @throws DAOException
     */
    public abstract List<T> findAll() throws DAOException;

    /**
     * Find entity with given id
     *
     * @param id Id of entity to find, id is primary key
     * @return Entity with given id
     * @throws DAOException
     */
    public abstract T findOneById(K id) throws DAOException;

    /**
     * Delete rows with given id
     *
     * @param id Id of entity to delete, id is primary key
     * @return true if delete was completed without errors
     * @throws DAOException
     */
    public abstract boolean delete(K id) throws DAOException;

    /**
     * Delete rows in db that fit given entity
     *
     * @param entity Entity that need to be deleted
     * @return true if delete was completed without errors
     * @throws DAOException
     */
    public abstract boolean delete(T entity) throws DAOException;

    /**
     * Insert rows that fit given entity in db
     *
     * @param entity Entity that need to be added
     * @return true if creation was completed without errors
     * @throws DAOException
     */
    public abstract boolean create(T entity) throws DAOException;

    /**
     * Update rows that fit given entity in db
     *
     * @param entity Entity that need to be updated
     * @return Updated entity
     * @throws DAOException
     */
    public abstract T update(T entity) throws DAOException;


    public void close(Statement st) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            logger.error("Can't close statement");
        }
    }

    public void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error("Can't close connection");
        }
    }

    /**
     *
     * @param connection
     */
    public void rollback(Connection connection){
        try {
            if(connection != null){
                connection.rollback();
            }
        } catch (SQLException ex){
            logger.error("Can't rollback changes");
        }
    }
}
