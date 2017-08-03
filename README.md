# android-aquery

/post/school/notice/list
Request (Query Parameter)
page=integer
ex) /post/school/notice/list?page=1
Response
[
{
  “Category”: integer,		// 0: 공지사항, 1: 가정통신문, 2: 대회
  “Number”: integer,		// 전체 글 번호
  “Content”: string,		// 글 내용
  “Title”: string,		// 제목
  “Attachments”:		// 첨부파일
  {
    “Size”: integer,		// 파일 크기
      “List”:			// 첨부파일 리스트
      [
        {
          “Link”: string,		// 다운로드 URL
          “Name”: string		// 파일 이름
        }
      ]
},
    “Writer”: string,		// 작성자
    “Date”: string,		// 작성일
    “HomeNumber”: integer	// 카테고리 내의 글 번호
}
]
Response code
200: 성공

/post/school/notice
Request (Query Parameter)
no=integer
ex) /post/school/notice?no=121
Response
{
“Category”: integer,
“Number”: integer,
“Content”: string,
“Title”: string,
“Attachments”:
{
  위와 같음. 생략
}
}
(설명도 위와 같아 생략함)
Response code
200: 성공
