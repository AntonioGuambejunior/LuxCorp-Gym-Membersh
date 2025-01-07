import java.io.*;
import java.text.DecimalFormat;


public class LuxCorpus 
{


  public static void main (String [] args) throws IOException
  {

		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		DecimalFormat mt = new DecimalFormat("###,###,###.00MTs");


		byte op;
		char tipoMembro, personalT = ' ', hidroginasticaG = ' ', tipoRef = ' ', nutri = ' ';
		int qtdAmigos, contG=0, contS=0, contN=0, qtdDiasT = 0;
		final float NORMAL=7500.0f, PTRAINER=250.0f, SILVER=11000.0f, HIDROGINASTICA=1000.0f,
				REFLEVE=300.0f, REFPSD=750.0f, GOLD=15000.0f, EXTRAGOLD_E=150.0f,
				GOLDNUTRI=2000.0f, DESC=20/100f;
		float valorPagar=0, acumS=0, acumG=0, acumN=0, acumTotal = 0, acumDesc=0, acumPT=0, acumNutriP=0, desconto, valorPT = 0, temp=0, temp2=0, temp3=0;
		boolean passou=false;

		do
		{


			System.out.println("****MENU****");
			System.out.println("1... Receber os dados e calcular o valor a pagar");
			System.out.println("2... Calcular a quantidade de membros de cada tipo");
			System.out.println("3... Calcular o valor total pago por cada tipo de membro");
			System.out.println("4... Calcular o valor total obtido pelo LuxCorpus;");
			System.out.println("5... Calcular o valor total de desconto");
			System.out.println("6... Calcular o valor total pago aos personal trainers");
			System.out.println("7... Calcular o valor total pago aos nutricionistas particulares");
			System.out.println("8... O tipo de membro que mais foi registado no ginasio");
			System.out.println("9... Verificar o balanco da empresa");
			System.out.println("10... Dados dos programadores");
			System.out.println("11... Sair");

			System.out.println("Escolha uma opcao (1-11)");
			do
			{
				op = Byte.parseByte(br.readLine());
				if (op<1 || op>11)
					System.out.println("Opcao Invalida, escolha entre 1 a 12");
			} while (op<1 || op>11);


			switch(op)
			{
			  case 1:
				  //DESBLOQUEIA AS OPCOES () DO MENU, POIS DEPENDIAM DA RECEPCAO DE DADOS PARA SEREM EXECUTADAS
				  passou=true;
				  //RECPCAO E VALIDACAO DO TIPO DE MEMBRO
				  System.out.println("Introduza o tipo de membro (S-Silver, G-Gold, N-Normal):");

				  do
				  {
					  tipoMembro=br.readLine().charAt(0);
					  if (tipoMembro != 's' && tipoMembro != 'S' && tipoMembro != 'G' && tipoMembro != 'g' && tipoMembro != 'N' && tipoMembro != 'n')
						  System.out.println("Tipo Invalido, escolha (S-Silver, G-Gold, N-Normal): ");
				  } while (tipoMembro != 's' && tipoMembro != 'S' && tipoMembro != 'G' && tipoMembro != 'g' && tipoMembro != 'N' && tipoMembro != 'n');

				  //RECEPCAO E VALIDACAO DA QUANTIDADE DE AMIGOS
				  System.out.println("Introduza a quantidade de amigos: ");
				  do
				  {
					  qtdAmigos=Integer.parseInt(br.readLine());
					  if (qtdAmigos < 0)
						  System.out.println("Invalido, introduza uma quantidade que nao seja inferior a um");
				  } while (qtdAmigos < 0);

				  //CALCULO DO VALOR A PAGAR
				  switch (tipoMembro)
				  {
				    case 'n' | 'N':
				    	valorPagar = NORMAL;
				    	//INCREMENTO DA QUQNATIDADE DE CLIENTES DO TIPO NORMAL
				    	contN++;
				    	//VERIFICAR SE O CLIENTE DESEJA TER PERSONAL TRAINER
				    	System.out.println("Deseja ter acesso ao personal trainer? (S-Sim, N-nao):");
				    	do
				    	{
				    		personalT= br.readLine().charAt(0);
				    		if (personalT != 's' && personalT != 'S' && personalT != 'n' && personalT != 'N' )
				    			System.out.println("Opcao invalida, introduza (S-Sim, N-nao):");
				    	} while (personalT != 's' && personalT != 'S' && personalT != 'n' && personalT != 'N' );
				    	if (personalT == 's' || personalT == 'S')
				    	{

				    		//RECEBER E VALIDAR A QUANTIDADE DE DIAS DE TREINO PARA POSTERIORMENTE AJUSTAR O VALOR A PAGAR
				    		System.out.println("Introduza a quantidade de dias de treino: (>0): ");
				    		do
				    		{
				    			qtdDiasT = Integer.parseInt(br.readLine());
				    			if (qtdDiasT <1)
				    				System.out.println("Quantidade invalida, introduza a partir de 1 para cima: ");
				    		} while (qtdDiasT <1);
				    		valorPT = (qtdDiasT * PTRAINER);
				    		valorPagar+=valorPT;
				    		//ACUMULAR O VALOR TOTAL PAGO AOS PERSONAL TRAINERS
				    		acumPT+=valorPT;
				    	}
				    	break;
				    case 'g' | 'G':
				    	valorPagar=GOLD;
				    	//INCREMENTO DO EXTRA DO ESTACIONAMENTO
				    	valorPagar+=EXTRAGOLD_E;
				    	//INCREMENTO DA QUANTIDADE DE CLIENTES DO TIPO GOLD
				    	contG++;
				    	//VERIFICAR SE PRETENDE TER NUTRICIONISTA OU NAO
				    	System.out.println("Pretende ter nutricionista? (S-Sim, N-Nao):");
				    	do
				    	{
				    		nutri=br.readLine().charAt(0);
				    		if (nutri != 's' && nutri != 'S' && nutri != 'n' && nutri != 'N')
				    			System.out.println("Opcao invalida, introduza (S-Sim, N-nao):");
				    	} while (nutri != 's' && nutri != 'S' && nutri != 'n' && nutri != 'N');
				    	if (nutri == 's' || nutri == 'S')
				    	{
				    		//ALTERAR O VALOR DO NUTRICIONISTA NA TABELA DOS DADOS DO TIPO GOLD CASO O CLIENTE QUEIRA UM NUTRICIONISTA
				    		temp=GOLDNUTRI;
				    		//INCREMENTO DO VALOR TOTAL PAGO AOS NUTRICIONISTAS PARTICULARES
				    		acumNutriP+=GOLDNUTRI;
				    		valorPagar += GOLDNUTRI;
				    	}

				    	break;
				    case 's' | 'S':
				    	valorPagar=SILVER;
				    	//INCREMENTO DA QUANTIDADE DE CLIENTES DO TIPO SILVER
				    	contS++;
				    	//VERIFICAR SE O CLIENTE PRETENDE REALIZAR HIDROGINASTICA COM GUIA
				    	System.out.println("Deseja realizar que tipo de hidroginastica? (L-Livre, G-Guiada):");
				    	do
				    	{
				    		hidroginasticaG= br.readLine().charAt(0);
				    		if (hidroginasticaG != 'g' && hidroginasticaG != 'G' && hidroginasticaG != 'l' && hidroginasticaG != 'l' )
				    			System.out.println("Opcao invalida, introduza (S-Sim, N-nao):");
				    	} while (hidroginasticaG != 'g' && hidroginasticaG != 'G' && hidroginasticaG != 'l' && hidroginasticaG != 'G' );
				    	if (hidroginasticaG == 'g' || hidroginasticaG =='G')
				    	{
				    		valorPagar += HIDROGINASTICA;
				    		//ALTERAR O VALOR DA HIDROGINASTICA NA TABELA REFERENTE AOS DADOS DO TIPO SILVER, CASO O CLIENTE QUEIRA HIDROGINASTICA GUIADA
				    		temp2=HIDROGINASTICA;
				    	}
				    	//RECEBER E VALIDAR O TIPO DE REFEICAO QUE O CLIENTE DESEJA TER (LEVE OU PESADA) E AJUSTAR O VALOR A PAGAR
				    	System.out.println("Introduza o tipo de refeicao que o cliente deseja ter (L-Leve, P-Pesada):");
				    	do
				    	{
				    		tipoRef=br.readLine().charAt(0);
				    		if (tipoRef != 'l' && tipoRef != 'L' && tipoRef != 'p' && tipoRef != 'P')
				    		{
				    			System.out.println("Tipo invalido, escolha (L-Leve, P-Pesada):");
				    		}
				    	} while (tipoRef != 'l' && tipoRef != 'L' && tipoRef != 'p' && tipoRef != 'P');
				    	switch (tipoRef)
				    	{
				    	  case 'l' | 'L': valorPagar+=REFLEVE;
				    	  				  temp3=REFLEVE;
				    		  break;
				    	  case 'p' | 'P': valorPagar+=REFPSD;
				    	  			      temp3=REFPSD;
				    		  break;
				    	}
				    	break;
				  }
				  //CALCULO DO DESCONTO E SUA APLICACAO NO VALOR A PAGAR
				  if (qtdAmigos >3)
				  {
					  desconto = valorPagar*DESC;
					  acumDesc += desconto;
					  valorPagar = valorPagar - desconto;
				  }
				  switch (tipoMembro)
				  {
				    case 'n' | 'N':
				    	acumN+=valorPagar;
				    	System.out.println("=========================================================================================");
				    	System.out.println("|  Membro  | Dias de treino | Personal Trainer | Valor personal trainer | Valor a pagar |");
				    	System.out.println("=========================================================================================");
				    	System.out.printf("|%10c|%16d|%18c|%24s|%15s|\n", tipoMembro, qtdDiasT, personalT, ' '+mt.format(valorPT), ' '+mt.format(valorPagar));
				    	System.out.println("=========================================================================================");

				    	break;
				    case 'g' | 'G':
				    	acumG+=valorPagar;


				        System.out.println("=====================================================================");
				        System.out.println("|  Membro  | Nutricionista | Valor do nutricionista | Valor a pagar |");
				        System.out.println("=====================================================================");
				        System.out.printf("|%10c|%15c|%24s|%15s|\n", tipoMembro, nutri, ' '+mt.format(temp), ' '+mt.format(valorPagar));
				        System.out.println("=====================================================================");

				    	break;
				    case 's' | 'S':
				    	acumS+=valorPagar;

				    	System.out.println("=============================================================================");
				    	System.out.println("| Membro | Hidro | Tipo Ref | Valor da Hidro | Valor da Ref | Valor a Pagar |");
				    	System.out.println("=============================================================================");
				    	System.out.printf("|%8c|%7c|%10c|%15s|%15s|%15s|\n", tipoMembro, hidroginasticaG, tipoRef, ' '+mt.format(temp2), ' '+mt.format(temp3), ' '+mt.format(valorPagar));
				    	System.out.println("=============================================================================");

				    	break;
				  }


				  break;
			  case 2:
				  if (passou == true)
					  System.out.println("Quantidade de Normal: "+contN+"\nQuantidade de Silver: "+contS+"\nQuantidade de Gold: "+contG);
				  else
					  System.out.println("Execute a opcao 1 primeiro");

				  break;
			  case 3:
				  if (passou == true)
					  System.out.println("Valor total por:\n-Normal: "+mt.format(acumN)+"\n-Silver: "+mt.format(acumS)+"\n-Gold: "+mt.format(acumG));
				  else
					  System.out.println("Execute a opcao 1 primeiro");
				  break;
			  case 4:
				  if (passou==true)
				  {
					  acumTotal = acumN+acumS+acumG;
					  System.out.println("O valor total obtido pelo Lux Corps e de: "+mt.format(acumTotal));
				  }
				  else
				  {
					  System.out.println("Execute a opcao 1 primeiro");
				  }
				  break;
			  case 5:
				  if (passou==true)
				  {
					  System.out.println("O valor total de desconto e de: "+mt.format(acumDesc));
				  }
				  else
				  {
					  System.out.println("Execute a opcao 1 primeiro");
				  }

				  break;
			  case 6:
				  if (passou==true)
				  {
					  System.out.println("O valor total pago aos personal trainers e de: "+mt.format(acumPT));
				  }
				  else
				  {
					  System.out.println("Execute a opcao 1 primeiro");
				  }
				  break;
			  case 7:
				  if (passou==true)
				  {
					  System.out.println("O valor total pago aos nutricionistas particulares e de: "+mt.format(acumNutriP));
				  }
				  else
				  {
					  System.out.println("Execute a opcao 1 primeiro");
				  }
				  break;
			  case 8:
				  if (passou==true)
				  {
					  if (contN>contS && contN>contG)
						  System.out.println("O tipo mais registado foi Normal");
					  else
					  {
						  if (contS>contN && contS>contG)
							  System.out.println("O tipo mais registado foi Silver");
						  else
							  System.out.println("O tipo mais registado foi Gold");
					  }
				  }
				  else
				  {
					  System.out.println("Execute a opcao 1 primeiro");
				  }
				  break;
			  case 9:
				  if (passou==true)
				  {
					  if(acumTotal>750000)
						  System.out.println("A empresa esta em lucro");
					  else
						  System.out.println("A empresa esta em prejuizo");
				  }
				  else
				  {
					  System.out.println("Execute a opcao 1 primeiro");
				  }

				  break;

			  case 10:
				  int codeJ=20241945, codeA=20240931, codeK=20240939;

				  System.out.println("<><><><><><><><><<><><>Dados dos programadores<><><><><><><><><><<><><>");
				  System.out.println("||            Nome               ||              Codigo              ||");
				  System.out.println("||<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><||");
				  System.out.print("||Jefferson Man Isaias Nhancale  ||");
				  System.out.printf("%34d||\n", codeJ);
				  System.out.println("||-------------------------------------------------------------------||");
				  System.out.print("||Antonio Jose Guambe Junior     ||");
				  System.out.printf("%34d||\n", codeA);
				  System.out.println("||-------------------------------------------------------------------||");
				  System.out.print("||Klisman Martin Manjate         ||");
				  System.out.printf("%34d||\n", codeK);
				  System.out.println("-----------------------------------------------------------------------");
				  break;

			  case 11: System.out.println("Obrigado por utilizar nossos servicos.");
				  break;
			}

		} while (op != 11);

	}
}
