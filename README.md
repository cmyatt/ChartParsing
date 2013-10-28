# About

An implementation of a passive chart parser used to parse natural language expressions with the use of a context free grammar.  
Below is the output of parsing 'a truck hit the tree in the garden' when packing is turned on:  

id	left	right	mother	daughters  
0	0	1	DT	(a)  
1	1	2	NP	(truck)  
2	0	2	NP	{(0, 1)}  
3	2	3	V	(hit)  
4	2	3	VP	{(3)}  
5	1	3	S	{(1, 4)}  
6	0	3	S	{(2, 4)}  
7	3	4	DT	(the)  
8	4	5	NP	(tree)  
9	3	5	NP	{(7, 8)}  
10	2	5	VP	{(3, 9)}  
11	1	5	S	{(1, 10)}  
12	0	5	S	{(2, 10)}  
13	5	6	P	(in)  
14	6	7	DT	(the)  
15	7	8	NP	(garden)  
16	6	8	NP	{(14, 15)}  
17	5	8	PP	{(13, 16)}  
18	4	8	NP	{(8, 17)}  
19	3	8	NP	{(7, 18), (9, 17)}  
20	2	8	VP	{(3, 19), (10, 17)}  
21	1	8	S	{(1, 20)}  
22	0	8	S	{(2, 20)}  
  
Spanning edges: 22  
  
The following grammar was used (see TestParser.java for how this is encoded within the program):  
  
S  --> NP VP  
S  --> PR VP  
VP --> VP PP  
VP --> V  
VP --> V NP  
VP --> V VP  
NP --> NP PP  
NP --> DT NP  
PP --> P NP  
  
PR --> he  
V  --> ate  
V  --> hit  
DT --> the  
DT --> a  
NP --> pizza  
NP --> truck  
NP --> tree  
NP --> garden  
P  --> with  
P  --> in  
NP --> fork  

