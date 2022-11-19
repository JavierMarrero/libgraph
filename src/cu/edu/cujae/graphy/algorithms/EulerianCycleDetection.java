package cu.edu.cujae.graphy.algorithms;
/** 
 * @author C�sar F�rnandez Garc�a
 * Esta clase permite ver si existe al menos un Ciclo Euleriano
 * */
import cu.edu.cujae.graphy.core.Graph;

import cu.edu.cujae.graphy.core.iterators.GraphIterator;

public class EulerianCycleDetection<V> extends AbstractAlgorithm<Boolean> {

	private final Graph<V> graph;
		
	public EulerianCycleDetection(Graph<V> graph) {
		super(true);
		this.graph = graph;
	}
	@Override
	public Algorithm<Boolean> apply() {
		//esta funcion lo que hace es ver si deja de cumplirse la paridad de los grados de los nodos
		boolean isOdd = false;
		GraphIterator<V> iterator = (GraphIterator<V>) graph.depthFirstSearchIterator(true);
		while(!isOdd && iterator.hasNext()) {
			iterator.next();
			int numberOfEdges = iterator.getAllAdjacentEdges().size();
			if( (numberOfEdges == 0) || ( (numberOfEdges % 2) == 1) ) {
				isOdd=true;
			}	
			
							
		}
		if(isOdd) {
			setResult(!isOdd);
		}
		
		return this;
	}
	public Graph<V> getGraph() {
		return graph;
	}
	
	
}






