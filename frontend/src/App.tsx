import { observer } from 'mobx-react-lite';
import Tabs from './components/tabs/tabs';
import Tab from './components/tabs/tab';
import Cep from './app/cep/view/cep';
import Log from './app/logs/view/log';

const App = observer(() => {
  return (
    <div className="p-4">
      <Tabs>
        <Tab title="Consultar Cep">
          <Cep />
        </Tab>
        <Tab title="Logs">
          <Log />
        </Tab>
      </Tabs>
    </div>
  );
});

export default App;
