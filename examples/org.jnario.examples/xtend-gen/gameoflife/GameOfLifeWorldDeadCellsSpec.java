package gameoflife;

import com.google.common.collect.Iterables;
import gameoflife.CellLocation;
import gameoflife.GameOfLifeWorldSpec;
import gameoflife.World;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hamcrest.StringDescription;
import org.jnario.lib.Should;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@SuppressWarnings("all")
@RunWith(ExampleGroupRunner.class)
@Named("deadCells")
public class GameOfLifeWorldDeadCellsSpec extends GameOfLifeWorldSpec {
  @Test
  @Named("with no live cells there are no dead cells")
  @Order(99)
  public void _withNoLiveCellsThereAreNoDeadCells() throws Exception {
    List<CellLocation> _emptyList = CollectionLiterals.<CellLocation>emptyList();
    World _worldWith = World.worldWith(_emptyList);
    Set<CellLocation> _deadCells = _worldWith.deadCells();
    Set<?> _emptySet = CollectionLiterals.emptySet();
    boolean _doubleArrow = Should.operator_doubleArrow(_deadCells, _emptySet);
    Assert.assertTrue("\nExpected worldWith(emptyList).deadCells => emptySet but"
     + "\n     worldWith(emptyList).deadCells is " + new StringDescription().appendValue(_deadCells).toString()
     + "\n     worldWith(emptyList) is " + new StringDescription().appendValue(_worldWith).toString()
     + "\n     emptyList is " + new StringDescription().appendValue(_emptyList).toString()
     + "\n     emptySet is " + new StringDescription().appendValue(_emptySet).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("with a live cell all neighbours are dead cells")
  @Order(99)
  public void _withALiveCellAllNeighboursAreDeadCells() throws Exception {
    Set<CellLocation> _deadCells = this.worldWithLiveCell.deadCells();
    Set<CellLocation> _neighbours = this.livingCell.neighbours();
    boolean _doubleArrow = Should.operator_doubleArrow(_deadCells, _neighbours);
    Assert.assertTrue("\nExpected worldWithLiveCell.deadCells => livingCell.neighbours but"
     + "\n     worldWithLiveCell.deadCells is " + new StringDescription().appendValue(_deadCells).toString()
     + "\n     worldWithLiveCell is " + new StringDescription().appendValue(this.worldWithLiveCell).toString()
     + "\n     livingCell.neighbours is " + new StringDescription().appendValue(_neighbours).toString()
     + "\n     livingCell is " + new StringDescription().appendValue(this.livingCell).toString() + "\n", _doubleArrow);
    
  }
  
  @Test
  @Named("with a live cell all non-living neighbours are dead cells")
  @Order(99)
  public void _withALiveCellAllNonLivingNeighboursAreDeadCells() throws Exception {
    Set<CellLocation> _deadCells = this.worldWithTwoLiveNeighbours.deadCells();
    Set<CellLocation> _allNonLivingNeighbours = this.allNonLivingNeighbours();
    boolean _doubleArrow = Should.operator_doubleArrow(_deadCells, _allNonLivingNeighbours);
    Assert.assertTrue("\nExpected worldWithTwoLiveNeighbours.deadCells => allNonLivingNeighbours but"
     + "\n     worldWithTwoLiveNeighbours.deadCells is " + new StringDescription().appendValue(_deadCells).toString()
     + "\n     worldWithTwoLiveNeighbours is " + new StringDescription().appendValue(this.worldWithTwoLiveNeighbours).toString()
     + "\n     allNonLivingNeighbours is " + new StringDescription().appendValue(_allNonLivingNeighbours).toString() + "\n", _doubleArrow);
    
  }
  
  public Set<CellLocation> allNonLivingNeighbours() {
    Set<CellLocation> _xblockexpression = null;
    {
      Set<CellLocation> _neighbours = this.livingCell.neighbours();
      Set<CellLocation> _neighbours_1 = this.anotherLivingCell.neighbours();
      Iterable<CellLocation> _plus = Iterables.<CellLocation>concat(_neighbours, _neighbours_1);
      final Set<CellLocation> allNonLivingNeighbours = IterableExtensions.<CellLocation>toSet(_plus);
      allNonLivingNeighbours.remove(this.anotherLivingCell);
      allNonLivingNeighbours.remove(this.livingCell);
      _xblockexpression = (allNonLivingNeighbours);
    }
    return _xblockexpression;
  }
}
