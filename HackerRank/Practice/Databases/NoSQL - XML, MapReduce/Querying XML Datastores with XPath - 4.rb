=begin

XPath는 XML 데이터베이스를 다루는 툴입니다. 
빠른 튜토리얼을 할 수 있는 링크는 http://edutechwiki.unige.ch/en/XPath_tutorial_-_basics 입니다.

XML이 다음과 같이 주어질 때 제목이 Trigun인 영화의 pupularity를 추출하세요.
다음 코드는 agnostic하여 Ruby를 공부하지 않은 사람이라도 맨 아래 빈 칸을 채우면 완성할 수 있습니다.

Input 

<collection shelf="Classics">
<movie title="The Enemy" shelf="A">
   <type>War, Thriller</type>
   <format>DVD</format>
   <year>2001</year>
   <rating>PG</rating>
   <popularity>10</popularity>
   <description>Talk about a war</description>
</movie>
<movie title="Transformers" shelf="B">
   <type>Science Fiction</type>
   <format>DVD</format>
   <year>1980</year>
   <rating>R</rating>
   <popularity>7</popularity>
   <description>Science Fiction</description>
</movie>
   <movie title="Trigun" shelf="B">
   <type>Action</type>
   <format>DVD</format>
   <episodes>4</episodes>
   <rating>PG</rating>
   <popularity>10</popularity>
   <description>Quite a bit of action!</description>
</movie>
<movie title="Ishtar" shelf="A">
   <type>Comedy</type>
   <format>VHS</format>
   <rating>PG</rating>
   <popularity>2</popularity>
   <description>Boring</description>
</movie>
</collection>

Output

   10 

=end

# Standard ruby library for XML parsing
require 'rexml/document'
include REXML

# Enter your code here. Read input from STDIN. Print output to STDOUT
# xmlText = "" 
xmlText = "movies.xml"

# Read the input XML Fragment
while line = gets()
	xmlText += line
end

doc = Document.new xmlText

# XPath Selector for listing the titles of the movies, in the same order as which they occur in the given XML.
# Fill in the blanks to complete the required XPath selector query
# puts doc.elements.each("collection/____________")
puts doc.elements.each("collection/movie[@title='Trigun']/popularity/text()")

