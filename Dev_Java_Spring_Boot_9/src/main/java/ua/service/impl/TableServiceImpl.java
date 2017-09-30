package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Table;
import ua.model.request.TableRequest;
import ua.model.view.CafeView;
import ua.repository.TableRepository;
import ua.service.TableService;

@Service
public class TableServiceImpl implements TableService {
	private final TableRepository repository;

	@Autowired
	public TableServiceImpl(TableRepository repository) {
		this.repository = repository;
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CafeView> findAllViewsCafe() {
		return repository.findAllViewsCafe();
	}

	@Override
	public List<Table> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(TableRequest request) {
		Table table = new Table();
		table.setCountOfPeople(request.getCountOfPeople());
		table.setFree(Boolean.valueOf(request.getIsFree().toUpperCase()));
		table.setCafe(request.getCafe());
		table.setId(request.getId());

		repository.save(table);

	}

	@Override
	public TableRequest findOne(Integer id) {
		Table table = repository.findOneRequest(id);
		TableRequest request = new TableRequest();
		request.setCafe(table.getCafe());
		request.setId(table.getId());
		request.setCountOfPeople(table.getCountOfPeople());
		request.setIsFree(String.valueOf(table.getisFree()));
		return request;
	}

	@Override
	public List<Table> findAllTablesbyIdCafe(Integer id) {

		return repository.findAllTablesbyIdCafe(id);
	}

	@Override
	public Table findOneTable(Integer id) {

		return repository.findOneTable(id);
	}

	@Override
	public List<Table> findAllTablesbyIdCafeReserved(Integer id, boolean isFree) {
		return repository.findAllTablesbyIdCafeReserved(id, isFree);
	}

	@Override
	public List<Integer> findAllTablesbyIdCafeReservedIDS(Integer id, boolean isFree) {

		return repository.findAllTablesbyIdCafeReservedIDS(id, isFree);
	}
}
