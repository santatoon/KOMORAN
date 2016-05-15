/*******************************************************************************
 * KOMORAN 3.0 - Korean Morphology Analyzer
 *
 * Copyright 2015 Shineware http://www.shineware.co.kr
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 	
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package kr.co.shineware.nlp.komoran.test;

import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

import java.util.List;

public class KomoranTest {

	public static void main(String[] args) throws Exception {

		Komoran komoran = new Komoran("models");
		komoran.setFWDic("user_data/fwd.user");
		komoran.setUserDic("user_data/dic.user");

		String input = "한번씩 피부가 뒤집어져서 시카페어 샘플써봤는데 🙊하루만에 가라앉았다🙊 그래서 바로사버렸닿ㅎㅎㅎ 나도 매끈매끈피부 하고싶어서 프라이머를 샀는데〰 매끈한피부가 프라이머하나로 만들어지는게 아닌거같다🙈 너무귀여워서 사버린 랑콤 쥬시쉐이커💄 오일이라그런지 발색은 연하지만 짱좋다 촉촉한입술👄 그리고 샘플로받은 랑콤향수가 너무좋다ㅠㅠ 담에사야지❣ 너무너무 기분좋게 베네피트 듀더훌라 당첨되따💃🏻💃🏻💃🏻 크림쉐딩인데 오늘내일써보고 후기남겨야지ㅎㅎ😝 이번달은 이렇게 끝🙋🏻";
		KomoranResult analyzeResultList = komoran.analyze(input);
		List<Token> tokenList = analyzeResultList.getTokenList();

		//print each tokens by getTokenList()
		System.out.println("==========print 'getTokenList()'==========");
		for (Token token : tokenList) {
			System.out.println(token);
			System.out.println(token.getMorph()+"/"+token.getPos()+"("+token.getBeginIndex()+","+token.getEndIndex()+")");
			System.out.println();
		}
		//print nouns
		System.out.println("==========print 'getNouns()'==========");
		System.out.println(analyzeResultList.getNouns());
		System.out.println();
		System.out.println("==========print 'getPlainText()'==========");
		System.out.println(analyzeResultList.getPlainText());
		System.out.println();
		System.out.println("==========print 'getList()'==========");
		System.out.println(analyzeResultList.getList());
	}
}
