Matinit:=[
[1,1,1,1,0,0,0,0,0,0,0,0],
[1,1,1,1,0,0,0,0,0,0,0,0],
[1,1,1,1,0,0,0,0,0,0,0,0],
[0,0,0,0,1,1,1,1,0,0,0,0],
[0,0,0,0,1,1,1,1,0,0,0,0],
[0,0,0,0,1,1,1,1,0,0,0,0],
[0,0,0,0,0,0,0,0,1,1,1,1],
[0,0,0,0,0,0,0,0,1,1,1,1],
[0,0,0,0,0,0,0,0,1,1,1,1]];
Minit:=Matrix(Integers(),Matinit);

function IsIntegerSingularValues(M)
EigenVal:=Eigenvalues(Transpose(M)*M);
IntegerMultiplicity:=0;
for x in EigenVal do
IntegerMultiplicity:=IntegerMultiplicity+x[2];
end for;
return IntegerMultiplicity eq 12;
end function;


MatrixToCanonicGraph:= function(A)
	Z0:=ZeroMatrix(Integers(),Ncols(A),Ncols(A));
	Z1:=ZeroMatrix(Integers(),Nrows(A),Nrows(A));
	A1:=VerticalJoin(HorizontalJoin(Z0,Transpose(A)),HorizontalJoin(A,Z1));
	Can:=CanonicalGraph(Graph<Nrows(A1)|A1>);
	return Can;
end function;


Switching:=function(M, i1,j1,i2,j2)

M[i1][j1]:=M[i1][j2];
M[i1][j2]:=1-M[i1][j2];

M[i2][j1]:=M[i2][j2];
M[i2][j2]:=1-M[i2][j2];

return(M);
end function;

Solutions:={};
SolMat:={**};
CanonicSetProcessed:={};
MatricesToDo:={Eltseq(Minit)};
MatricesToDoCanonic:={MatrixToCanonicGraph(Minit)};	
	repeat
	 
	 // Running cycle for all possible switchings
	 // check if the matrix is new
	 Mx:=Random(MatricesToDo); 
	 M:=Matrix(Integers(),9,12,Mx);
	 Graph1:=MatrixToCanonicGraph(M);
	 if Graph1 in CanonicSetProcessed then 
	 else
	 Include(~CanonicSetProcessed,Graph1);
	 for i in [1..Nrows(M)] do
	 for j in [i+1..Nrows(M)] do
     
     SwitchingColumns:={{s,t}: s,t in [1..Ncols(M)]|([M[i][s], M[j][s]]eq [0,1] and [M[i][t], M[j][t]]eq [1,0] or 
[M[i][s], M[j][s]]eq [1,0] and [M[i][t], M[j][t]]eq [0,1])	 and s ne t};
	
     for z in SwitchingColumns do 
	 z1:= Setseq(z); 
	 M1:=Switching(M,i,z1[1],j,z1[2]); 
	 GrapH:= MatrixToCanonicGraph(M1);
	    if GrapH in CanonicSetProcessed then 
	 else
	 
     if GrapH in MatricesToDoCanonic then
	 else
	 //Include(~CanonicSetProcessed,GrapH);
	 Include(~MatricesToDoCanonic,GrapH);
	 Include(~MatricesToDo,Eltseq(M1));
	 if IsIntegerSingularValues(M1) then
         Include(~Solutions,GrapH);
         Include(~SolMat,M1);
	 end if;
	 end if;
	 end if;
	 end for;	 
	 end for;
	 end for;
	 end if;
	 Exclude(~MatricesToDo,Mx);
	 Exclude(~MatricesToDoCanonic,Graph1);
	 
	 "---";
	 
	 #MatricesToDo;
"Soluts";
#Solutions;
#SolMat;	 

// Append(~L, [-1,0,1]);	
// Matlist:=L[1];
// mat:= Matrix

// #(CanoniclGraph(D2), Can)
	
	
	until #MatricesToDo eq 0;
	
	