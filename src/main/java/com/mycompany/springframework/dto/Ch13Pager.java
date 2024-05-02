package com.mycompany.springframework.dto;

import lombok.Data;

@Data
public class Ch13Pager {
   private int totalRows;      //페이징 대상이 되는 전체 행수 (ex.10000)
   private int totalPageNo;   //전체 페이지 수(ex. 한 페이지에 10개가 들어가면 1000)
   private int totalGroupNo;   //전체 그룹 수(1~10, 11~20, ... )(위 조건을 만족하면 전체 그룹은 100개)
   private int startPageNo;   //그룹의 시작 페이지 번호(1,11...)
   private int endPageNo;      //그룹의 끝 페이지 번호(10,20...)
   private int pageNo;         //현재 페이지 번호
   private int pagesPerGroup;   //그룹당 페이지 수
   private int groupNo;      //현재 그룹 번호 (ex. 3페이지를 보고 있으면 1~10 그룹에 속한다.)
   private int rowsPerPage;   //페이지당 행 수 
   private int startRowNo;      //페이지의 시작 행 번호(1, ..., n)
   private int startRowIndex;   //페이지의 시작 행 인덱스(0, ..., n-1) for mysql
   private int endRowNo;      //페이지의 마지막 행 번호
   private int endRowIndex;   //페이지의 마지막 행 인덱스

   public Ch13Pager(int rowsPerPage, int pagesPerGroup, int totalRows, int pageNo) {
      this.rowsPerPage = rowsPerPage;
      this.pagesPerGroup = pagesPerGroup;
      this.totalRows = totalRows;
      this.pageNo = pageNo;

      totalPageNo = totalRows / rowsPerPage; // 전체 페이지 수 = 페이징 대상이 되는 전체 행 수 / 페이지 당 행 수 
      if(totalRows % rowsPerPage != 0) totalPageNo++;
      
      totalGroupNo = totalPageNo / pagesPerGroup; // 전체 그룹 수 = 전체 페이지 수  / 그룹 당 페이지 수
      if(totalPageNo % pagesPerGroup != 0) totalGroupNo++;
      
      groupNo = (pageNo - 1) / pagesPerGroup + 1; 
      
      startPageNo = (groupNo-1) * pagesPerGroup + 1;
      
      endPageNo = startPageNo + pagesPerGroup - 1;
      if(groupNo == totalGroupNo) endPageNo = totalPageNo;
      
      startRowNo = (pageNo - 1) * rowsPerPage + 1;
      startRowIndex = startRowNo - 1;
      endRowNo = pageNo * rowsPerPage;
      endRowIndex = endRowNo - 1; 
   }
}
