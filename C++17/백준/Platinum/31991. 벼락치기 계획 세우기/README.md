# [Platinum V] 벼락치기 계획 세우기 - 31991 

[문제 링크](https://www.acmicpc.net/problem/31991) 

### 성능 요약

메모리: 2612 KB, 시간: 172 ms

### 분류

다이나믹 프로그래밍, 배낭 문제

### 제출 일자

2025년 10월 7일 00:37:59

### 문제 설명

<p>유민이는 이번 학기에 무려 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개 과목의 기말고사를 봐야 한다! 각 과목의 성적은 낮은 순서부터 F, D-, D0, D+, C-, C0, C+, B-, B0, B+, A-, A0, A+로 총 13단계로 분류되며, 수로 환산되는 평점은 각각 0.0, 0.7, 1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 4.3점이다.</p>

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>i</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$i$</span></mjx-container>번째 과목의 시험 시각은 지금으로부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D461 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>t</mi><mi>i</mi></msub></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$t_i$</span></mjx-container>시간 뒤이고, 이수학점은 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>c</mi><mi>i</mi></msub></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$c_i$</span></mjx-container>학점이다. 또, 그 과목에서 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D457 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>j</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$j$</span></mjx-container>번째로 낮은 평점을 얻기 위해서는 해당 과목을 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D460 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-texatom size="s" texclass="ORD"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D457 TEX-I"></mjx-c></mjx-mi></mjx-texatom></mjx-script></mjx-msub></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>s</mi><mrow data-mjx-texclass="ORD"><mi>i</mi><mo>,</mo><mi>j</mi></mrow></msub></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$s_{i,j}$</span></mjx-container>시간 이상 공부해야 한다. 각 과목은 시험 시각 이전까지만 공부할 수 있고, 여러 과목을 동시에 공부할 수는 없다. 시험을 치르는 데 걸리는 시간은 없다고 가정하고, 여러 시험을 동시에 칠 수도 있다.</p>

<p>늘 그랬듯 아직까지 공부를 전혀 하지 않은 유민이는 효율적인 벼락치기를 통해 평점평균을 최대화하려고 한다. 평점평균이란 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개 과목 각각에 대하여 이수학점과 그 과목에서 유민이가 얻은 평점의 곱의 총합을 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개 과목의 이수학점의 총합으로 나눈 값이다. F학점을 받은 과목도 이수학점 계산에 반영된다.</p>

<table align="center" border="1" cellpadding="1" cellspacing="1" class="table table-bordered" style="width: 100%;">
	<tbody>
		<tr>
			<td colspan="1" rowspan="2" style="text-align: center; vertical-align: middle;">과목명</td>
			<td colspan="1" rowspan="2" style="text-align: center; vertical-align: middle;">시험 시각</td>
			<td colspan="1" rowspan="2" style="text-align: center; vertical-align: middle;">이수학점</td>
			<td colspan="13" rowspan="1" style="text-align: center;">평점을 얻기 위한 공부 시간</td>
		</tr>
		<tr>
			<td style="text-align: center;">F(0.0)</td>
			<td style="text-align: center;">D-(0.7)</td>
			<td style="text-align: center;">D0(1.0)</td>
			<td style="text-align: center;">D+(1.3)</td>
			<td style="text-align: center;">C-(1.7)</td>
			<td style="text-align: center;">C0(2.0)</td>
			<td style="text-align: center;">C+(2.3)</td>
			<td style="text-align: center;">B-(2.7)</td>
			<td style="text-align: center;">B0(3.0)</td>
			<td style="text-align: center;">B+(3.3)</td>
			<td style="text-align: center;">A-(3.7)</td>
			<td style="text-align: center;">A0(4.0)</td>
			<td style="text-align: center;">A+(4.3)</td>
		</tr>
		<tr>
			<td style="text-align: center;">미적분1</td>
			<td style="text-align: center;">30</td>
			<td style="text-align: center;">4</td>
			<td style="text-align: center;">0</td>
			<td style="text-align: center;">3</td>
			<td style="text-align: center;">7</td>
			<td style="text-align: center;">10</td>
			<td style="text-align: center;">14</td>
			<td style="text-align: center;">16</td>
			<td style="text-align: center;">20</td>
			<td style="text-align: center;"><strong>27</strong></td>
			<td style="text-align: center;">30</td>
			<td style="text-align: center;">60</td>
			<td style="text-align: center;">88</td>
			<td style="text-align: center;">120</td>
			<td style="text-align: center;">200</td>
		</tr>
		<tr>
			<td style="text-align: center;">세계사</td>
			<td style="text-align: center;">80</td>
			<td style="text-align: center;">3</td>
			<td style="text-align: center;">0</td>
			<td style="text-align: center;">2</td>
			<td style="text-align: center;">4</td>
			<td style="text-align: center;">6</td>
			<td style="text-align: center;">8</td>
			<td style="text-align: center;">10</td>
			<td style="text-align: center;">30</td>
			<td style="text-align: center;">50</td>
			<td style="text-align: center;">52</td>
			<td style="text-align: center;"><strong>53</strong></td>
			<td style="text-align: center;">198</td>
			<td style="text-align: center;">199</td>
			<td style="text-align: center;">200</td>
		</tr>
		<tr>
			<td style="text-align: center;">수학3</td>
			<td style="text-align: center;">180</td>
			<td style="text-align: center;">3</td>
			<td style="text-align: center;">0</td>
			<td style="text-align: center;">5</td>
			<td style="text-align: center;">10</td>
			<td style="text-align: center;">15</td>
			<td style="text-align: center;">20</td>
			<td style="text-align: center;">25</td>
			<td style="text-align: center;">35</td>
			<td style="text-align: center;">50</td>
			<td style="text-align: center;">75</td>
			<td style="text-align: center;">80</td>
			<td style="text-align: center;">90</td>
			<td style="text-align: center;">95</td>
			<td style="text-align: center;"><strong>100</strong></td>
		</tr>
		<tr>
			<td style="text-align: center;">정보과학3</td>
			<td style="text-align: center;">200</td>
			<td style="text-align: center;">3</td>
			<td style="text-align: center;">0</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;">1</td>
			<td style="text-align: center;"><strong>2</strong></td>
		</tr>
	</tbody>
</table>

<p>예를 들어, 위 상황에서는 다음과 같이 공부하는 것이 최선이다.</p>

<ul>
	<li>먼저 미적분1을 27시간 공부한다.</li>
	<li>다음으로 세계사를 3시간 공부한다.</li>
	<li>미적분1 시험을 친다. 총 27시간을 공부했으므로 B-(2.7)를 받게 된다.</li>
	<li>세계사를 50시간 더 공부한다.</li>
	<li>세계사 시험을 친다. 총 53시간을 공부했으므로 B+(3.3)를 받게 된다.</li>
	<li>수학3을 100시간 공부한다.</li>
	<li>수학3 시험을 친다. 총 100시간을 공부했으므로 A+(4.3)을 받게 된다.</li>
	<li>정보과학3 시험까지 남은 20시간 중 2시간 이상 정보과학3을 공부한다.</li>
	<li>정보과학3 시험을 친다. 총 2시간 이상을 공부했으므로 A+(4.3)을 받게 된다.</li>
</ul>

<p>이때 평점평균은 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mfrac><mjx-frac><mjx-num><mjx-nstrut></mjx-nstrut><mjx-mrow size="s"><mjx-mpadded><mjx-block style="margin: 0.86em 0px 0.3em;"><mjx-mrow></mjx-mrow></mjx-block></mjx-mpadded><mjx-mstyle style="font-size: 141.4%;"><mjx-texatom texclass="ORD"><mjx-mn class="mjx-n"><mjx-c class="mjx-c34"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c32"></mjx-c><mjx-c class="mjx-c2E"></mjx-c><mjx-c class="mjx-c37"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c33"></mjx-c><mjx-c class="mjx-c2E"></mjx-c><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c34"></mjx-c><mjx-c class="mjx-c2E"></mjx-c><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c34"></mjx-c><mjx-c class="mjx-c2E"></mjx-c><mjx-c class="mjx-c33"></mjx-c></mjx-mn></mjx-texatom></mjx-mstyle></mjx-mrow></mjx-num><mjx-dbox><mjx-dtable><mjx-line></mjx-line><mjx-row><mjx-den><mjx-dstrut></mjx-dstrut><mjx-mrow size="s"><mjx-mpadded><mjx-block style="margin: 0.86em 0px 0.3em;"><mjx-mrow></mjx-mrow></mjx-block></mjx-mpadded><mjx-mstyle style="font-size: 141.4%;"><mjx-texatom texclass="ORD"><mjx-mn class="mjx-n"><mjx-c class="mjx-c34"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c33"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c33"></mjx-c></mjx-mn></mjx-texatom></mjx-mstyle></mjx-mrow></mjx-den></mjx-row></mjx-dtable></mjx-dbox></mjx-frac></mjx-mfrac><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2248"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c33"></mjx-c><mjx-c class="mjx-c2E"></mjx-c><mjx-c class="mjx-c35"></mjx-c><mjx-c class="mjx-c37"></mjx-c><mjx-c class="mjx-c36"></mjx-c><mjx-c class="mjx-c39"></mjx-c><mjx-c class="mjx-c32"></mjx-c><mjx-c class="mjx-c33"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c37"></mjx-c><mjx-c class="mjx-c36"></mjx-c><mjx-c class="mjx-c39"></mjx-c><mjx-c class="mjx-c32"></mjx-c><mjx-c class="mjx-c33"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mfrac><mrow><mpadded height="8.6pt" depth="3pt" width="0"><mrow></mrow></mpadded><mstyle displaystyle="false" scriptlevel="0"><mrow data-mjx-texclass="ORD"><mn>4</mn><mo>×</mo><mn>2.7</mn><mo>+</mo><mn>3</mn><mo>×</mo><mn>3.3</mn><mo>+</mo><mn>3</mn><mo>×</mo><mn>4.3</mn><mo>+</mo><mn>3</mn><mo>×</mo><mn>4.3</mn></mrow></mstyle></mrow><mrow><mpadded height="8.6pt" depth="3pt" width="0"><mrow></mrow></mpadded><mstyle displaystyle="false" scriptlevel="0"><mrow data-mjx-texclass="ORD"><mn>4</mn><mo>+</mo><mn>3</mn><mo>+</mo><mn>3</mn><mo>+</mo><mn>3</mn></mrow></mstyle></mrow></mfrac><mo>≈</mo><mn>3.576923076923</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\cfrac{4\times 2.7 + 3\times 3.3 + 3\times 4.3 + 3\times 4.3}{4+3+3+3} \approx 3.576923076923$</span></mjx-container>점이다.</p>

### 입력 

 <p>첫 번째 줄에 과목의 수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>이 주어진다.</p>

<p>두 번째 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 줄에 과목들의 정보가 주어지며, 그 중 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>i</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$i$</span></mjx-container>번째 줄에는 15개의 정수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msub><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D461 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-msub space="2"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-mi class="mjx-i" size="s"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi></mjx-script></mjx-msub><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-msub space="2"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D460 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-texatom size="s" texclass="ORD"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-texatom></mjx-script></mjx-msub><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-msub space="2"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D460 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-texatom size="s" texclass="ORD"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn></mjx-texatom></mjx-script></mjx-msub><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mo class="mjx-n" space="2"><mjx-c class="mjx-c22EF"></mjx-c></mjx-mo><mjx-mo class="mjx-n" space="2"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-msub space="2"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D460 TEX-I"></mjx-c></mjx-mi><mjx-script style="vertical-align: -0.15em;"><mjx-texatom size="s" texclass="ORD"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D456 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c33"></mjx-c></mjx-mn></mjx-texatom></mjx-script></mjx-msub></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msub><mi>t</mi><mi>i</mi></msub><mo>,</mo><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><msub><mi>c</mi><mi>i</mi></msub><mo>,</mo><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><msub><mi>s</mi><mrow data-mjx-texclass="ORD"><mi>i</mi><mo>,</mo><mn>1</mn></mrow></msub><mo>,</mo><msub><mi>s</mi><mrow data-mjx-texclass="ORD"><mi>i</mi><mo>,</mo><mn>2</mn></mrow></msub><mo>,</mo><mo>⋯</mo><mo>,</mo><msub><mi>s</mi><mrow data-mjx-texclass="ORD"><mi>i</mi><mo>,</mo><mn>13</mn></mrow></msub></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$t_i,\, c_i,\, s_{i,1}, s_{i,2}, \cdots , s_{i,13}$</span></mjx-container>이 공백을 사이에 두고 주어진다.</p>

### 출력 

 <p>유민이가 받을 수 있는 평점평균의 최댓값을 출력한다. 절대오차 또는 상대오차는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-msup><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-script style="vertical-align: 0.393em;"><mjx-texatom size="s" texclass="ORD"><mjx-mo class="mjx-n"><mjx-c class="mjx-c2212"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c36"></mjx-c></mjx-mn></mjx-texatom></mjx-script></mjx-msup></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><msup><mn>10</mn><mrow data-mjx-texclass="ORD"><mo>−</mo><mn>6</mn></mrow></msup></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$10^{-6}$</span></mjx-container>까지 허용한다.</p>

