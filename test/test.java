//Tạo CriteriaBuilder
CriteriaBuilder cb = session.getCriteriaBuilder();

// Tạo CriteriaQuery
CriteriaQuery<Tuple> cq = cb.createTupleQuery();

// Xác định các root
Root<PhieuMuonModel> pmRoot = cq.from(PhieuMuonModel.class);
Join<PhieuMuonModel, DocGiaModel> dgJoin = pmRoot.join("MaDocGia");
Join<PhieuMuonModel, SachModel> sachJoin = pmRoot.join("DSsach");

// Tạo subquery để tìm ngày mượn mới nhất của mỗi quyển sách
Subquery<Date> subquery = cq.subquery(Date.class);
Root<PhieuMuonModel> subPmRoot = subquery.from(PhieuMuon.class);
Join<PhieuMuonModel, SachModel> subSachJoin = subPmRoot.join("DSsach");
subquery.select(cb.greatest(subPmRoot.get("NgayMuon")))
        .where(cb.equal(subSachJoin.get("MaSach"), sachJoin.get("MaSach")),
                cb.equal(subPmRoot.get("MaDocGia").get("MaDG"), maDocGia),
                cb.equal(sachJoin.get("tinhTrang"), "Đang mượn"));

// Tạo truy vấn chính
cq.select(cb.tuple(
        sachJoin.get("MaSach"),
        sachJoin.get("TenSach"),
        pmRoot.get("NgayMuon")
)).where(cb.equal(dgJoin.get("MaDG"), maDocGia),
        cb.equal(sachJoin.get("TinhTrang"), "Đang mượn"),
        cb.equal(pmRoot.get("NgayMuon"), subquery));

List<Tuple> results = session.createQuery(cq).getResultList();
// Thực hiện truy vấn

import java.sql.Date;

import DAO.PhieuMuon;
import DAO.Tuple;
import Model.DocGiaModel;
import Model.PhieuMuonModel;
import Model.SachModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
