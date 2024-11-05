package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry", Entry.class);
        return query.getResultList();
    }

    @Transactional
    public boolean deleteEntry(Long id) {
        Entry entry = entityManager.find(Entry.class, id);
        if (entry != null) {
            entityManager.remove(entry);
            return true;
        }
        return false;
    }

    @Transactional
    public Entry updateEntry(Long id, Entry updatedEntry) {
        Entry existingEntry = entityManager.find(Entry.class, id);
        if (existingEntry != null) {
            existingEntry.setSomeField(updatedEntry.getSomeField());
            existingEntry.setOtherField(updatedEntry.getOtherField());
            entityManager.merge(existingEntry);
            return existingEntry;
        }
        return null;
    }
}
