import java.util.Random;
import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class GeneticALG {
	public GeneticALG(int chromosome_size, int  genetic_base, int population_size /*, double crossover, double mutation, double elite_pool*/) 
	{
		chromosome_size = chromosome_size;
		genetic_base = genetic_base;
	//	crossover = crossover;
	//	mutation = mutation;
	//	elite_pool = elite_pool;
		population_size = population_size;
		int fitness_test[] = new int [genetic_base];
		int population[][] = new int[population_size][chromosome_size + 1];
		int generation = 0;
		
		Random generator = new Random();
		//Seeds an array that is the population with a chromosome. In the array the first [] is population position and the second [] is chromsome position. So for example [3][5] Would be the 3rd member of the populus at the fifth point of the chromosome
		for(int i=0; i<population_size; i++)
		{
			for(int x=0; x<genetic_base; x++)
			{
				population[i][x] = generator.nextInt(chromosome_size)+1;
				
			}
			
		}
		
		//setting up the fitness to be tested against
		for (int i=0; i<genetic_base; i++)
		{
			fitness_test[i] = fitness(chromosome_size, i);
		}
		
		/*test for fitness function to make sure it is working correctly.
		test_fitness(population, population_size, genetic_base, fitness_test);\
		*/
		
		for (int i =0; i<population_size; i++)
		{
			for(int x =0; x<genetic_base; x++)
			{
				population[i][10] += test_fitness(population, fitness_test, i, x);
				
			}
		}	
				
		population = sort(population, population_size, genetic_base);
		
		for (int i =0; i<population_size; i++)
		{
			System.out.println("the fitness of population member" + i + "is" + population[i][10]);				
		}
			
		
		
	}
///////////////////////////////////////////// bottom of main class //////////////////////////////////////////////////	
	
	public static int breed(int[][] population, int population_size, int genetic_base)
	//define fitness
	public static int fitness(int chromosome_size,int pos)
	{
		int[] fitness = new int [chromosome_size];
		fitness[0] = 3;
		fitness[2] = 2;
		fitness[3] = 1;
		fitness[4] = 1;
		fitness[5] = 7;
		fitness[6] = 6;
		fitness[7] = 7;
		fitness[8] = 9;
		fitness[9] = 10;
		fitness[9] = 12;
		
		return fitness[pos];
	}
	
	//test fitness
	public static int test_fitness(int[][] population, int[] fitness_test, int i, int x)
	{
		if (population[i][x] == fitness_test[x])
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	//sorting class
	public static int[][] sort(int[][] population,int population_size,int genetic_base)
	{
		boolean sorted=false;
		int [][] temp = population;
		
		while(sorted==false)
		{
			sorted = true;
			for (int i =0; i<population_size-1; i++)
			{
				for(int x =0; x<genetic_base; x++)
				{
					if(population[i][10] < population[i+1][10])
					{
						//assigns position one to temp
						temp[i][x] = population[i + 1][x];
						temp[i][10] = population[i][10];
						// assigning position two genetic base to position one.
						population[i][x] = population[i+1][x];
						population[i][10] = population[i+1][10];
						//assigning temp to position two
						population[i+1][x] = temp[i][x];
						population[i+1][10] = temp[i][10];
						
						sorted = false;
						
					}
					
					
					
				}
			}
		
		}
		
		return population;
	}
	//main class starting geneticALG class
	public static void main(String[] args) {
		
	GeneticALG species = new GeneticALG(12, 10, 50/*, elite_pool=0.60*/);
	}

}
